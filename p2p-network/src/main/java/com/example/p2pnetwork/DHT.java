package com.example.p2pnetwork;

import java.util.*;

public class DHT {

    private Map<String, String> table;  // Key-value store

    public DHT() {
        this.table = new HashMap<>();
    }

    // Put key-value pairs into DHT
    public void put(String key, String value) {
        table.put(key, value);  
    }

    // Retrieve value from DHT
    public String get(String key) {
        return table.get(key);  // Retrieve file metadata
    }

    // Remove a key-value pair from DHT
    public void removeKeyDHT(String key) {
        table.remove(key);
    }

    // Return the entire DHT table
    public Map<String, String> getTable() {
        return table;
    }
}
