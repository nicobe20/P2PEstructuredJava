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
            // Crear un nuevo nodo con ID aleatorio
            Node currentNode = new Node();
            int boostrapperPort = 8080;

            // Pedir el número de puerto
            System.out.println("Ingrese el número de puerto para este nodo: ");
            int port = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.println("Ingresa la direccion ip o 'localhost' de un nodo boostrap para poder conectarse a la red (si es la creacion de nodo boostrap dejar vacio!!!");
            String bootstrapAddress = scanner.nextLine();

            // Iniciar el servidor gRPC
            Server server = ServerBuilder.forPort(port)
                    .addService(new P2PServiceImpl(currentNode))
                    .build();

            System.out.println("gRPC Server iniciando en el puerto " + port + "...");
            server.start();
            System.out.println("gRPC Server iniciado en el puerto " + port);

            //Bootstrap node
            if (!bootstrapAddress.isEmpty()) {
                System.out.println("trying to connect to the bootstrapper node on: " + bootstrapAddress);
                ManagedChannel channel = ManagedChannelBuilder.forAddress(bootstrapAddress, boostrapperPort).usePlaintext().build();
                P2PServiceGrpc.P2PServiceBlockingStub stub = P2PServiceGrpc.newBlockingStub(channel);

                //Try to join the network
                NodeInfoRequest joinRequest = NodeInfoRequest.newBuilder().setNodeId(currentNode.getIdNode()).build();

                try {
                    NodeInfoResponse response = stub.getNodeInfo(joinRequest);
                    currentNode.setPredecessor(new Node(response.getPredecessorId()));
                    currentNode.setSuccessor(new Node(response.getSuccessorId()));
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

            // Mantener el servidor en ejecución
            server.awaitTermination();
        }
    }
}
