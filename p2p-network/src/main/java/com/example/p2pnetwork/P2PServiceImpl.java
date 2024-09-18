package com.example.p2pnetwork;

import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.stub.StreamObserver;

public class P2PServiceImpl extends P2PServiceGrpc.P2PServiceImplBase {

    private Node currentNode;

    public P2PServiceImpl(Node node) {
        this.currentNode = node;
    }

    // Ping simulation method
    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        String senderNode = request.getSenderNode();
        String receiverNode = request.getReceiverNode();

        if (receiverNode != null) {
            System.out.println("Ping received from " + senderNode + " to " + receiverNode);
            PingResponse response = PingResponse.newBuilder()
                    .setStatus("Ping successful from " + senderNode + " to " + receiverNode)
                    .build();

            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new Throwable("Receiver node " + receiverNode + " not found."));
        }
        responseObserver.onCompleted();
    }

    // Join the network implementation
    @Override
public void joinNetwork(JoinRequest request, StreamObserver<JoinResponse> responseObserver) {
    String nodeId = request.getNodeId();
    
    // Current node joins the network (no need to pass the newNode as an argument)
    currentNode.joinNetwork();  // Fix here: no arguments needed

    JoinResponse response = JoinResponse.newBuilder()
            .setStatus("Node with ID: " + nodeId + " joined successfully.")
            .setSuccessorId(currentNode.getSuccessor().getIdNode())
            .setPredecessorId(currentNode.getPredecessor().getIdNode())
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
}

    // Get node info implementation
    @Override
    public void getNodeInfo(NodeInfoRequest request, StreamObserver<NodeInfoResponse> responseObserver) {
    String nodeId = request.getNodeId();

    // Check if the current node has a valid successor and predecessor
    String successorId = (currentNode.getSuccessor() != null) ? currentNode.getSuccessor().getIdNode() : "null";
    String predecessorId = (currentNode.getPredecessor() != null) ? currentNode.getPredecessor().getIdNode() : "null";

    NodeInfoResponse response = NodeInfoResponse.newBuilder()
            .setNodeId(currentNode.getIdNode())
            .setSuccessorId(successorId)  // Handle potential null values
            .setPredecessorId(predecessorId)  // Handle potential null values
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
}

}
