package com.mastercode.consistent.hashing;

public class Main {
    public static void main(String[] args) {
        ConsistentHash consistentHash = new ConsistentHash(3);

        Server server1 = new Server("192.168.0.1");
        Server server2 = new Server("192.168.0.2");
        Server server3 = new Server("192.168.0.3");

        consistentHash.addServer(server1);
        consistentHash.addServer(server2);
        consistentHash.addServer(server3);

        System.out.println("Initial Hash Ring:");
        consistentHash.printHashRing();
        String key = "some_key";

        System.out.println();
        System.out.println();
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));
        System.out.println();
        System.out.println();
        // Assume a new server is added to the cluster
        Server newServer = new Server("192.168.0.4");
        consistentHash.addServer(newServer);

        System.out.println("\nHash Ring after adding a new server:");
        consistentHash.printHashRing();

        System.out.println();
        System.out.println();
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));
        System.out.println();
        System.out.println();
        // Assume a server is removed from the cluster
        consistentHash.removeServer(server2);

        System.out.println("\nHash Ring after removing a server:");
        consistentHash.printHashRing();
        System.out.println();
        System.out.println();
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));
        System.out.println();
        System.out.println();
        // Get the server for a specific key
        System.out.println("\nServer for key '" + key + "': " + consistentHash.getServerForKey(key));

    }
}