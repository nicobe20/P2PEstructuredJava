package com.example.p2pnetwork;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Scanner;

import com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest;
import com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            Node currentNode = new Node();
            System.out.println("Ingrese el número de puerto para este nodo: ");
            int port = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Ingresa la direccion ip o 'localhost' de un nodo boostrap para poder conectarse a la red (si es la creacion de nodo boostrap dejar vacio!!!)");
            String bootstrapAddress = scanner.nextLine();

            // Start the gRPC server
            Server server = ServerBuilder.forPort(port)
                    .addService(new P2PServiceImpl(currentNode))
                    .build();

            System.out.println("gRPC Server iniciando en el puerto " + port + "...");
            server.start();
            System.out.println("gRPC Server iniciado en el puerto " + port);

            //Boostrapper node for starting setup
            if (!bootstrapAddress.isEmpty()) {
                System.out.println("trying to connect to the bootstrapper node on: " + bootstrapAddress);
                int boostrapperPort = 8080;  
                ManagedChannel channel = ManagedChannelBuilder.forAddress(bootstrapAddress, boostrapperPort).usePlaintext().build();
                P2PServiceGrpc.P2PServiceBlockingStub stub = P2PServiceGrpc.newBlockingStub(channel);


                NodeInfoRequest joinRequest = NodeInfoRequest.newBuilder().setNodeId(currentNode.getIdNode()).build();

                try {
                    NodeInfoResponse response = stub.getNodeInfo(joinRequest);
                    currentNode.setPredecessor(new Node(response.getPredecessorId()));
                    currentNode.setSuccessor(new Node(response.getSuccessorId()));

                
                    for (String otherNodeId : response.getOtherNodesList()) {
                        System.out.println("Connected to node: " + otherNodeId);
                    }

                    System.out.println("Joined network successor: " + response.getSuccessorId() + " And predecessor: " + response.getPredecessorId());
                } catch (Exception e) {
                    System.out.println("Joining failed :( \n" + e.getMessage());
                } finally {
                    channel.shutdown();
                }

            } else {
                System.out.println("Joining the net as the bootstrap node.");
                currentNode.joinNetwork();
            }

            
            runClientConsole(currentNode.getIdNode(), port);
            server.awaitTermination();
        }
    }

    public static void runClientConsole(String nodeId, int port) {
        try (Scanner scanner = new Scanner(System.in)) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
            P2PClient client = new P2PClient(nodeId);

            while (true) {
                System.out.println("Ingrese un comando (ping/estado/exit): ");
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase("exit")) {
                    break;
                } else if (command.equalsIgnoreCase("ping")) {
                    System.out.println("Ingrese el ID del nodo al que quieres hacer ping: ");
                    String targetNodeId = scanner.nextLine();
                    client.ping(nodeId, targetNodeId);
                } else if (command.equalsIgnoreCase("estado")) {
                    Node.printNetworkState();
                } else {
                    System.out.println("Comando no reconocido. Intente 'ping', 'estado' o 'exit'.");
                }
            }

            // Close the channel and client once done
            client.shutdown();
            channel.shutdown();
        }
    }
}
