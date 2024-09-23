package com.example.p2pnetwork;

import java.util.*;

public class DHT {

    private Map<String, String> table; 

    public DHT() {
        this.table = new HashMap<>();
    }
    public void put(String key, String value) {
        table.put(key, value);  
    }
    public String get(String key) {
        return table.get(key); 
    }
    public void removeKeyDHT(String key) {
        table.remove(key);
    }
    public Map<String, String> getTable() {
        return table;
    }
}
