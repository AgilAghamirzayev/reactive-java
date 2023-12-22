package com.mastercode.consistent.hashing;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash {
    private final SortedMap<Integer, Server> hashRing;
    private final Integer numberOfReplicas;

    public ConsistentHash(Integer numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
        this.hashRing = new TreeMap<>();
    }

    private int hash(String key) {
        return key.hashCode();
    }

    public void addServer(Server server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String virtualServerIp = server.ipAddress() + "-" + i;
            int hash = hash(virtualServerIp);
            hashRing.put(hash, server);
        }
    }

    public void removeServer(Server server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String virtualServerIp = server.ipAddress() + "-" + i;
            int hash = hash(virtualServerIp);
            hashRing.remove(hash);
        }
    }

    public Server getServerForKey(String key) {
        if (hashRing.isEmpty()) {
            return null;
        }

        int hash = hash(key);

        // Find the first server key greater than or equal to the hash key
        SortedMap<Integer, Server> tailMap = hashRing.tailMap(hash);
        Integer firstServerKey = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();

        return hashRing.get(firstServerKey);
    }

    public void printHashRing() {
        for (Map.Entry<Integer, Server> entry : hashRing.entrySet()) {
            System.out.println("Hash: " + entry.getKey() + ", Server: " + entry.getValue().ipAddress());
        }
    }

}