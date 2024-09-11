package com.example.p2pnetwork;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        Server server = ServerBuilder.forPort(8080)
                .addService(new P2PServiceImpl())
                .build();

        System.out.println("gRPC Server is starting...");
        server.start();
        System.out.println("gRPC Server started on port 8080");

        // Keep the server running
        server.awaitTermination();
    }
}
