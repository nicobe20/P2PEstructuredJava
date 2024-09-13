package com.example.p2pnetwork;

import java.util.*;


public class DHT {
    
    private Map<String, String> table;  // Key-value store

    public DHT() {
        this.table = new HashMap<>();
    }
    //Key pairs for DHT 
    public void put(String key, String value) {
        table.put(key, value);  
        //System.out.println("Key:" + key + "stored :" + value);
    }

    public String get(String key) {
        return table.get(key);  // Retrieve file metadata

    }

    public void removeKeyDHT(String Key){
        table.remove(Key);

    }
    public Map<String, String> getTable(){
        return table;
    }
}
