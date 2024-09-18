package com.example.p2pnetwork;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {

    private String idNode;
    private Node successor;
    private Node predecessor;

    // This list should be shared among all nodes (static)
    private static List<Node> nodeList = new ArrayList<>();

    // Constructor that assigns a random ID to the node
    public Node() {
        this.idNode = generateRandomID();
        this.successor = null; // Initially null
        this.predecessor = null; // Initially null
        addToNetwork();  // Automatically add node to the network when created
        System.out.println("Node with ID: " + this.idNode + " has been created.");
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
        if (nodeList.size() == 1) {
            // This node is the only one in the network, so it becomes its own successor and predecessor
            this.successor = this;
            this.predecessor = this;
        } else {
            // Find the appropriate place for the new node
            Node successorNode = findSuccessor(this.idNode);
            Node predecessorNode = successorNode.getPredecessor();

            // Insert the new node between the predecessor and successor
            this.setPredecessor(predecessorNode);
            this.setSuccessor(successorNode);
            predecessorNode.setSuccessor(this);
            successorNode.setPredecessor(this);
        }
        addToNetwork();  // Add the node to the network list
        System.out.println("Node with ID: " + this.idNode + " has joined the network.");
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
