package com.example.p2pnetwork;

import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class P2PServiceImpl extends P2PServiceGrpc.P2PServiceImplBase {

    private Node currentNode;

    public P2PServiceImpl(Node node) {
        this.currentNode = node;
    }


    // Implementación del servicio Ping
    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        //To print who sends and who recieves
        String senderNode = request.getSenderNode();
        String receiverNode = request.getReceiverNode();

        if (receiverNode != null){

        System.out.println("Ping recibido de " + senderNode + " hacia " + receiverNode);

        PingResponse response = PingResponse.newBuilder().setStatus("Ping exitoso de " + senderNode + " a " + receiverNode).build(); 

        responseObserver.onNext(response);
        
    }else{
        responseObserver.onError(new Throwable("Nodo con id:"+ receiverNode +"No pudo realizarse" ));
    }
    responseObserver.onCompleted();
}

    // Implementación del servicio GetNodeInfo
    @Override
    public void getNodeInfo(NodeInfoRequest request, StreamObserver<NodeInfoResponse> responseObserver) {
        String nodeId = request.getNodeId();
        Node node = Node.findNodeById(nodeId);

        if (node != null) {
            NodeInfoResponse response = NodeInfoResponse.newBuilder()
                    .setNodeId(node.getIdNode())
                    .setSuccessorId(node.getSuccessor().getIdNode())
                    .setPredecessorId(node.getPredecessor().getIdNode())
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new Throwable("Nodo no encontrado"));
        }
        responseObserver.onCompleted();
    }

    
    public void runConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Ingrese un comando (ping/exit/estado): ");
                
                String command = scanner.nextLine();
                
                if (command.equalsIgnoreCase("exit")) {
                    currentNode.leaveNetwork();
                    break;
                } else if (command.equalsIgnoreCase("ping")) {
                    System.out.println("Ingrese el ID del nodo objetivo para hacer ping: ");

                    String targetNodeId = scanner.nextLine();

                    String currentNodeId = currentNode.getIdNode();

                    //Node targetNode = Node.findNodeById(targetNodeId);
                    
                    P2PClient client = new P2PClient(currentNodeId);

                    if (targetNodeId != null) {
                    
                        client.ping(currentNodeId,targetNodeId);
                    
                    } else {
                    
                        System.out.println("Nodo no encontrado.");
                    
                    }
                } 
                else if(command.equalsIgnoreCase("estado")) {
                    Node.printNetworkState();
                }else{
                    System.out.println("Comando no reconocido. Intente 'ping', 'estado' o 'exit'.");
                }
            }
        }
    }
}

