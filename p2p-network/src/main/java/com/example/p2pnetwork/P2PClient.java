package com.example.p2pnetwork;
import java.security.MessageDigest;

import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class P2PClient {

    public static void main(String[] args) {

            // Set up a channel to connect to the gRPC server
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                    .usePlaintext()
                    .build();
    
            // Create a stub to interact with the service
            P2PServiceGrpc.P2PServiceBlockingStub stub = P2PServiceGrpc.newBlockingStub(channel);
    
            // Create a file transfer request
            FileTransferRequest request = FileTransferRequest.newBuilder()
                    .setFilename("sample_file.txt")
                    .setFileSize("5MB")
                    .setSenderNode("Node_A")
                    .setReceiverNode("Node_B")
                    .build();
    
            // Send the request to the server and receive a response
            FileTransferResponse response = stub.simulateFileTransfer(request);
    
            // Print the response details
            System.out.println("File Transfer Status: " + response.getStatus());
            System.out.println("Details: " + response.getDetails());
    
            // Close the channel after communication
            channel.shutdown();



        /* 
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // Create a blocking stub for the P2PService
        P2PServiceGrpc.P2PServiceBlockingStub stub = P2PServiceGrpc.newBlockingStub(channel);

        // Create a request
        MessageRequest request = MessageRequest.newBuilder()
                .setMessage("Testing message ")
                .build();

        // Send the request and receive a response
        MessageResponse response = stub.sendMessage(request);
       

        // Print the response
        
            System.out.println("Response from server: " + response.getConfirmation());
        
        
        // Shut down the channel
        channel.shutdown();

        */
    }
}



