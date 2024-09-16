package com.example.p2pnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {

    private String idNode;
    private Node successor;
    private Node predecessor;
    private static List<Node> nodeList = new ArrayList<>();

    // Constructor que asigna un ID aleatorio automáticamente
    public Node() {
        this.idNode = generateRandomID();
        this.successor = this;
        this.predecessor = this;
        nodeList.add(this); // Registrar el nodo en la red
        System.out.println("Node with ID: " + this.idNode + " has joined the network.");
    }

    // Generar un ID aleatorio
    private String generateRandomID() {
        return UUID.randomUUID().toString();
    }

    public String getIdNode() {
        return idNode;
    }

    public Node getSuccessor() {
        return successor;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setSuccessor(Node successor) {
        this.successor = successor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    // Unir un nuevo nodo a la red y actualizar sucesores/predecesores   aqui hay problemas
    public void joinNetwork(Node newNode) {
        if (this.successor == this && this.predecessor == this) {
            // Si este es el único nodo en la red, el nuevo nodo será su sucesor y predecesor
            this.successor = newNode;
            this.predecessor = newNode;
            newNode.setPredecessor(this);
            newNode.setSuccessor(this);
        } else {
            Node successorNode = findSuccessor(newNode.getIdNode());
            Node predecessorNode = successorNode.getPredecessor();

            newNode.setPredecessor(predecessorNode);
            newNode.setSuccessor(successorNode);
            predecessorNode.setSuccessor(newNode);
            successorNode.setPredecessor(newNode);
        }
        nodeList.add(newNode);
        System.out.println("Node with ID: " + newNode.getIdNode() + " has joined the network.");
    }

    // Encontrar el sucesor para un nodo con una ID específica

    public Node findSuccessor(String key) {
    if (this.successor == null || (this.idNode.compareTo(key) < 0 && this.successor.getIdNode().compareTo(key) >= 0) || this.idNode.compareTo(this.successor.getIdNode()) > 0) {
        return this;
    } else {
        return this.successor.findSuccessor(key);
    }
}

    // Dejar la red y actualizar sucesores/predecesores
    public void leaveNetwork() {
        if (this.successor != null && this.predecessor != null && this.successor != this) {
            this.successor.setPredecessor(this.predecessor);
            this.predecessor.setSuccessor(this.successor);
            nodeList.remove(this);
            System.out.println("Node with ID: " + this.idNode + " has left the network.");
        } else {
            // Si es el único nodo en la red
            System.out.println("Node with ID: " + this.idNode + " es el único nodo en la red y no puede dejar la red.");
        }
    }

    // Mostrar el estado actual de la red
    public static void printNetworkState() {
        System.out.println("Current network state:");
        for (Node node : nodeList) {
            System.out.println("Node ID: " + node.getIdNode() +
                               " | Predecessor: " + (node.getPredecessor() != null ? node.getPredecessor().getIdNode() : "null") +
                               " | Successor: " + (node.getSuccessor() != null ? node.getSuccessor().getIdNode() : "null"));
        }
    }

    // Encuentra un nodo por su ID
    public static Node findNodeById(String id) {
        for (Node node : nodeList) {
            if (node.getIdNode().equals(id)) {
                return node;
            }
        }
        return null;
    }
}
