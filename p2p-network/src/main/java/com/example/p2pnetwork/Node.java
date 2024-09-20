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

    // Constructor that assigns a random ID to the node
    public Node() {
        this.idNode = generateRandomID();
        this.successor = null; // Initially null
        this.predecessor = null; // Initially null
        addToNetwork();  // Automatically add node to the network when created
        System.out.println("Node with ID: " + this.idNode + " has been created.");
    }

    //implemented this constructor to pass the ids of existing nodes
    public Node(String idNode) {
        this.idNode = idNode;  
        this.successor = null; 
        this.predecessor = null; 
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
    /* 
    public void joinNetwork() {
    synchronized (nodeList) {
        if (nodeList.size() == 0) {
            // Primer nodo en la red, se apunta a sí mismo
            this.successor = this;
            this.predecessor = this;
        } else {
            // Encontrar el sucesor adecuado en la red
            Node successorNode = findSuccessor(this.idNode);
            Node predecessorNode = successorNode.getPredecessor();

            // Asignar predecesor y sucesor
            this.setPredecessor(predecessorNode);
            this.setSuccessor(successorNode);
            predecessorNode.setSuccessor(this);
            successorNode.setPredecessor(this);
        }
        nodeList.add(this);  // Añadir a la lista global de nodos
        System.out.println("Nodo " + this.idNode + " se ha unido a la red.");
    }
}

*/

public void joinNetwork() {
    synchronized (nodeList) {
        if (nodeList.size() >= 1) {
            this.successor = this;
            this.predecessor = this;
            if (!nodeList.contains(this)) {
                nodeList.add(this);  
                System.out.println("Bootstrap node added to the network. Node list size: " + nodeList.size());
            }
        }if (nodeList.isEmpty()) {
            System.out.println("No nodes available in the network to join.");
            return;
        } else {
           
            Node successorNode = findSuccessor(this.idNode);
            if (successorNode != null) {
                Node predecessorNode = successorNode.getPredecessor();

                // Verificar si el predecesor existe
                if (predecessorNode != null) {
                    this.setPredecessor(predecessorNode);
                    predecessorNode.setSuccessor(this);
                } else {
                    System.out.println("No se pudo encontrar un predecesor válido.");
                }

                this.setSuccessor(successorNode);
                successorNode.setPredecessor(this);
            } else {
                System.out.println("No se pudo encontrar un sucesor válido.");
            }
        }
        nodeList.add(this);  // Añadir a la lista global de nodos
        System.out.println("Nodo " + this.idNode + " se ha unido a la red.");
    }
}

    //high hopes
    public void updateSuccessorAndPredecessor(List<String> nodeIds) {
        if (nodeIds == null || nodeIds.isEmpty()) {
            System.out.println("No valid nodes in the list to connect to.");
            return;  // Early return if there are no valid nodes
        }
    
        Collections.sort(nodeIds);  // Sort the list of node IDs
    
        // Find the correct successor
        for (String nodeId : nodeIds) {
            if (nodeId.compareTo(this.idNode) > 0) {
                this.successor = new Node(nodeId);
                break;
            }
        }
    
        // If no larger node is found, wrap around to the first node
        if (this.successor == null) {
            this.successor = new Node(nodeIds.get(0));  // Wrap around
        }
    
        // Find the correct predecessor
        for (int i = nodeIds.size() - 1; i >= 0; i--) {
            if (nodeIds.get(i).compareTo(this.idNode) < 0) {
                this.predecessor = new Node(nodeIds.get(i));
                break;
            }
        }
    
        // If no smaller node is found, wrap around to the last node
        if (this.predecessor == null) {
            this.predecessor = new Node(nodeIds.get(nodeIds.size() - 1));  // Wrap around
        }
    
        System.out.println("Node " + this.idNode + " updated with successor: " + this.successor.getIdNode() + 
                            " and predecessor: " + this.predecessor.getIdNode());
    }
    
    





    // Find the successor node based on the node ID
    public Node findSuccessor(String key) {
        for (Node node : nodeList) {
            if (node.getIdNode().compareTo(key) > 0) {
                return node;
            }
        }
        // If no larger node ID is found, return the first node (wrap-around case)
        return nodeList.get(0);  // This means the smallest ID wraps around to the first node
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
