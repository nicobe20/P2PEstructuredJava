package com.example.p2pnetwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Node {

    private String idNode;
    private Node successor;
    private Node predecessor;

    // This list should be shared among all nodes (static)
    static List<Node> nodeList = Collections.synchronizedList(new ArrayList<>());

    // Default constructor (for new nodes) - assigns a random UUID
    public Node() {
        this.idNode = generateRandomID();
        this.successor = null; // Initially null
        this.predecessor = null; // Initially null
        addToNetwork();  // Automatically add node to the network when created
        System.out.println("Node with ID: " + this.idNode + " has been created.");
    }

    // Constructor that assigns a specific ID (for predecessor and successor)
    public Node(String idNode) {
        this.idNode = idNode;  // Use the provided ID from the response
        this.successor = null; // Initially null
        this.predecessor = null; // Initially null
    }

    // Method to add a node to the network
    private void addToNetwork() {
        if (!nodeList.contains(this)) {
            nodeList.add(this);
        }
    }

    // Generate a random ID for the node
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

    // Join the network and correctly assign successors and predecessors
    public void joinNetwork() {
        synchronized (nodeList) {
            if (nodeList.size() >= 1) {
                // First node in the network, point to itself
                this.successor = this;
                this.predecessor = this;
                System.out.println("Bootstrapper node self-assigned as predecessor and successor.");
            } else {
                // Find the appropriate successor and predecessor for the new node
                Node successorNode = findSuccessor(this.idNode);
                Node predecessorNode = successorNode.getPredecessor();

                // Set the new node's successor and predecessor
                this.setSuccessor(successorNode);
                this.setPredecessor(predecessorNode);

                // Update the predecessor's and successor's links
                predecessorNode.setSuccessor(this);
                successorNode.setPredecessor(this);

                System.out.println("Node joined with predecessor: " + predecessorNode.getIdNode() + " and successor: " + successorNode.getIdNode());
            }

            nodeList.add(this);  // Add the new node to the global list
            System.out.println("Node " + this.idNode + " has joined the network.");
        }
    }

    // Find the successor node based on the node ID
    public Node findSuccessor(String key) {
        for (Node node : nodeList) {
            if (node.getIdNode().compareTo(key) > 0) {
                return node;
            }
        }
        // If no larger node ID is found, return the first node (wrap-around case)
        return nodeList.get(0);
    }

    // Print the current network state
    public static void printNetworkState() {
        if (nodeList.isEmpty()) {
            System.out.println("No nodes in the network.");
            return;
        }

        System.out.println("Current network state:");
        for (Node node : nodeList) {
            String predecessorId = (node.getPredecessor() != null) ? node.getPredecessor().getIdNode() : "null";
            String successorId = (node.getSuccessor() != null) ? node.getSuccessor().getIdNode() : "null";

            System.out.println("Node ID: " + node.getIdNode() +
                    " | Predecessor: " + predecessorId +
                    " | Successor: " + successorId);
        }
    }
}
