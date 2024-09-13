package com.example.p2pnetwork;

import java.util.*;


//Class that represents each node in the network
public class Node {
    //Node class atributes 
    private String idNode;
    private Node succesor;
    private Node predecessor;
    private DHT dhtTable;

    //Constructor for node
    public Node(String Id_Node){
        
        String macAddr = javaUtil.getMacAddr();

        this.idNode = idNode;

        this.dhtTable = new DHT();
    }

    //Methods(getters and setters)

    //getters
    public String getIdNode(){
        return idNode;
    }

    public Node getSuccesorNode(){
        return succesor;    
    }

    public Node getPredecessorNode(){
        return predecessor;
    }

    public DHT getdhtTable(){
        return dhtTable;
    } 

    //Setters for succesor and predecessor 

    public void setSuccesorNode(Node succesor){
        this.succesor = succesor;
    }

    public void setPredecessor(Node predecessor){
        this.predecessor = predecessor;
    }

    //Method to join new nodes

    public void join(Node newNode){
        //Task ----> implement chord logic or any logic to make succesor and predecessor
        //if we are to do a ring like chord we also have to implemente the position of the node to be in the correct position of the circle 
        if (this.succesor == null){
            this.succesor = newNode;
            this.predecessor = newNode;
            newNode.setPredecessor(this);
            newNode.setSuccesorNode(this);

        }
        else {
            //Chord impl for correct node position this shit is very *fucking* confusing
            
            Node succNode = findSuccesorNode(newNode.getIdNode());//succNode is the value or id of the newNode to join the network being pass to the method of findSuccesorNode
            Node predNode = succNode.getPredecessorNode(); //just returns the predecessor node of the new node

            //fuck this
            newNode.setPredecessor(predNode);
            newNode.setSuccesorNode(succNode);
            succNode.setPredecessor(newNode);
            predNode.setSuccesorNode(newNode);

        }
    }

    public Node findSuccesorNode(String Key){
        //implement logic to finde succesor node 
        if (this.idNode.compareTo(Key) < 0 
                    && (this.succesor.getIdNode().compareTo(Key) >= 0)){   //the compareTo returns 0 when the two strings compared are exactly equal.
           
                          return this.succesor;

        }else{
            return this.succesor.findSuccesorNode(Key); //recursivley find the succesor.

        }
    }



}
