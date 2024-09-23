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

        // Current node joins the network
        currentNode.joinNetwork();
        JoinResponse.Builder responseBuilder = JoinResponse.newBuilder()
                .setStatus("Node " + nodeId + " joined successfully.")
                .setSuccessorId(currentNode.getSuccessor().getIdNode())
                .setPredecessorId(currentNode.getPredecessor().getIdNode());

        synchronized (Node.nodeList) {
            for (Node node : Node.nodeList) {
                responseBuilder.addOtherNodes(node.getIdNode());
            }
        }

        JoinResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Get node info implementation
    @Override
    public void getNodeInfo(NodeInfoRequest request, StreamObserver<NodeInfoResponse> responseObserver) {
        String successorId = (currentNode.getSuccessor() != null) ? currentNode.getSuccessor().getIdNode() : currentNode.getIdNode();
        String predecessorId = (currentNode.getPredecessor() != null) ? currentNode.getPredecessor().getIdNode() : currentNode.getIdNode();

        // Build and send the response
        NodeInfoResponse response = NodeInfoResponse.newBuilder()
                .setNodeId(currentNode.getIdNode())
                .setSuccessorId(successorId)
                .setPredecessorId(predecessorId)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
