package com.example.p2pnetwork;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.example.p2pnetwork.P2PServiceProto.NodeInfoRequest;
import com.example.p2pnetwork.P2PServiceProto.NodeInfoResponse;
import com.example.p2pnetwork.P2PServiceProto.NodeListRequest;
import com.example.p2pnetwork.P2PServiceProto.NodeListResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear un nuevo nodo con ID aleatorio
            Node currentNode = new Node();
            int boostrapPort = 8080;
            // Pedir el número de puerto
            System.out.println("Ingrese el número de puerto para este nodo: ");
            int port = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Imprimir el estado de la red (para depuración)
            //Node.printNetworkState(); //not working

            //Extra we need to implement the bootstrap node 
            //here goes 
            System.out.println("Ingresa la direccion ip o 'localhost' de un nodo boostrap para poder conectarse a la red (si es la creacion de nodo boostrap dejar vacio!!!)");
            String bootstrapAddress = scanner.nextLine();

            // Iniciar el servidor gRPC
            Server server = ServerBuilder.forPort(port)
                    .addService(new P2PServiceImpl(currentNode))
                    .build();

            System.out.println("gRPC Server iniciando en el puerto " + port + "...");
            server.start();
            System.out.println("gRPC Server iniciado en el puerto " + port);

            //Boostrap node  
            if (!bootstrapAddress.isEmpty()) {
                System.out.println("Trying to connect to the bootstrapper node on: " + bootstrapAddress);
            
                // Here, use the port of the bootstrap node, not the current node's port
                ManagedChannel channel = ManagedChannelBuilder.forAddress(bootstrapAddress, boostrapPort).usePlaintext().build();
                P2PServiceGrpc.P2PServiceBlockingStub stub = P2PServiceGrpc.newBlockingStub(channel);
            
                // Try to join the network
                NodeInfoRequest joinRequest = NodeInfoRequest.newBuilder()
                                           .setNodeId(currentNode.getIdNode())
                                           .build();
                
                try {
                    // Send the join request to the bootstrap node
                    NodeInfoResponse joinResponse = stub.getNodeInfo(joinRequest);
                    
                    System.out.println("Joined network with successor: " + joinResponse.getSuccessorId() 
                                       + " and predecessor: " + joinResponse.getPredecessorId());
            
                    // After joining, request the node list from the bootstrap node
                    NodeListRequest listRequest = NodeListRequest.newBuilder().setNodeId(currentNode.getIdNode()).build();
                    NodeListResponse listResponse = stub.getNodeList(listRequest);
                    
                    List<String> nodeIds = listResponse.getNodeIdsList();
                    System.out.println("Received node list from bootstrap: " + nodeIds);
                    
                    // Update successor and predecessor in the current node based on the node list
                    currentNode.updateSuccessorAndPredecessor(nodeIds);
                    
                } catch (Exception e) {
                    System.out.println("Failed to join the network: " + e.getMessage());
                    
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
