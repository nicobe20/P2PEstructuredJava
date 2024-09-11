package com.example.p2pnetwork;
import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.stub.StreamObserver;


public class P2PServiceImpl extends P2PServiceGrpc.P2PServiceImplBase {

    @Override
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        // Extract the message from the request
        String message = request.getMessage();
        System.out.println("Received: " + message);

        // Build a response message
        MessageResponse response = MessageResponse.newBuilder()
                .setConfirmation("Message received: " + message)
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}