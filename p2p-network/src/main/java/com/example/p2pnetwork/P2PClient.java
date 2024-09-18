package com.example.p2pnetwork;

import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class P2PClient {

    private final ManagedChannel channel;
    private final P2PServiceGrpc.P2PServiceBlockingStub stub;

    // Constructor que establece un canal gRPC con el nodo
    public P2PClient(String nodeId) {
        // Suponiendo que cada nodo está en una dirección conocida.
        this.channel = ManagedChannelBuilder.forTarget("localhost:8080") // Puedes ajustar el host/puerto
                .usePlaintext()
                .build();
        this.stub = P2PServiceGrpc.newBlockingStub(channel);
    }

    // Método para hacer ping a otro nodo
    //vueltota
    public void ping(String senderNodeId, String receiverNodeId) {
        PingRequest request = PingRequest.newBuilder()
                .setSenderNode(senderNodeId)
                .setReceiverNode(receiverNodeId)
                .build();

        try {
            PingResponse response = stub.ping(request); //stub generated here

            System.out.println("Respuesta del ping: " + response.getStatus());
        } catch (StatusRuntimeException e) {
            System.err.println("Error durante el ping: " + e.getStatus());
        }
    }

    // Método para obtener información de un nodo
    /* 
    public void getNodeInfo(String nodeId) {
        NodeInfoRequest request = NodeInfoRequest.newBuilder()
                .setNodeId(nodeId)
                .build();

        try {
            NodeInfoResponse response = stub.getNodeInfo(request);
            System.out.println("Nodo: " + response.getNodeId());
            System.out.println("Sucesor: " + response.getSuccessorId());
            System.out.println("Predecesor: " + response.getPredecessorId());
        } catch (StatusRuntimeException e) {
            System.err.println("Error al obtener información del nodo: " + e.getStatus());
        }
    }
*/
    // Método para cerrar el canal gRPC
    public void shutdown() {
        channel.shutdown();
    }

    // Consola interactiva para el cliente
    public static void runClientConsole(P2PClient client, String nodeId) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese un comando (ping/estado/exit): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("ping")) {
                System.out.println("Ingrese el ID del nodo al que quieres hacer ping: ");

                String targetNodeId = scanner.nextLine();
                
                client.ping(nodeId, targetNodeId);
            
            } else if(command.equalsIgnoreCase("estado")) {
                Node.printNetworkState();
            }else {
                System.out.println("Comando no reconocido. Intente 'ping', 'estado' o 'exit'.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el ID del nodo actual
        System.out.println("Ingrese el ID de este nodo (cliente): ");
        String nodeId = scanner.nextLine();

        // Crear el cliente para conectarse al nodo
        P2PClient client = new P2PClient(nodeId);

        // Ejecutar la consola interactiva
        runClientConsole(client, nodeId);

        // Cerrar el cliente al finalizar
        client.shutdown();
        System.out.println("Cliente desconectado.");
    }
}
