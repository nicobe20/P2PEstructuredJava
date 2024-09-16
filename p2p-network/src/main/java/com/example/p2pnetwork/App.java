package com.example.p2pnetwork;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear un nuevo nodo con ID aleatorio
            Node currentNode = new Node();

            // Pedir el número de puerto
            System.out.println("Ingrese el número de puerto para este nodo: ");
            int port = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Imprimir el estado de la red (para depuración)
            Node.printNetworkState();

            // Iniciar el servidor gRPC
            Server server = ServerBuilder.forPort(port)
                    .addService(new P2PServiceImpl(currentNode))
                    .build();

            System.out.println("gRPC Server iniciando en el puerto " + port + "...");
            server.start();
            System.out.println("gRPC Server iniciado en el puerto " + port);

            // Mantener el servidor en ejecución
            server.awaitTermination();
        }
    }
}
