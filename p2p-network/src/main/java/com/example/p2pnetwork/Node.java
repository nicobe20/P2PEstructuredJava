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

    }

    public Node findSuccesorNode(String Key){
        //implement logic to finde succesor node 
       return succesor; //Placeholder 
    }



}
