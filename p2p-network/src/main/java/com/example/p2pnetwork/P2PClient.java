package com.example.p2pnetwork;
import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class P2PClient {
    public static void main(String[] args) {
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // Create a blocking stub for the P2PService
        P2PServiceGrpc.P2PServiceBlockingStub stub = P2PServiceGrpc.newBlockingStub(channel);

        // Create a request
        MessageRequest request = MessageRequest.newBuilder()
                .setMessage("que bacaneria, me de ll in incorrecto bogota xd ")
                .build();

        // Send the request and receive a response
        MessageResponse response = stub.sendMessage(request);

        // Print the response
        System.out.println("Response from server: " + response.getConfirmation());

        // Shut down the channel
        channel.shutdown();
    }
}
