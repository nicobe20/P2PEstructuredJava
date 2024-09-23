# P2P Network with gRPC and Distributed Hash Table (DHT)

This project implements a peer-to-peer (P2P) network in Java using gRPC for communication between nodes. Each node in the network can store and retrieve data in a Distributed Hash Table (DHT) and communicate with other nodes to maintain the network structure. The network follows a ring topology, where each node is aware of its successor and predecessor.

## Features

- **gRPC Communication**: Each node runs a gRPC server, allowing it to communicate with other nodes through Remote Procedure Calls (RPC).
- **Distributed Hash Table (DHT)**: The DHT enables distributed storage of key-value pairs across the network.
- **P2P Architecture**: The network is decentralized. Nodes can join or leave the network dynamically, and they maintain knowledge of their successors and predecessors.
- **Ping Simulation**: Nodes can send ping messages to each other to check connectivity.
- **Successor and Predecessor Management**: Each node knows its successor and predecessor, ensuring the network is connected in a logical ring.
- **Random Node IDs**: Each node is assigned a random ID upon creation, and the network organizes nodes based on these IDs.

## Table of Contents

1. [Installation](#installation)
2. [Usage](#usage)
   - [Running the Bootstrap Node](#running-the-bootstrap-node)
   - [Connecting a New Node](#connecting-a-new-node)
3. [Project Structure](#project-structure)
4. [Future Improvements](#future-improvements)

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/p2pnetwork.git
   cd p2pnetwork
   
2. **Build the Project**
   ```bash
   mvn clean install

## Usage

1. **Running the Bootstrap Node**:
   ```bash
   java -jar target/p2pnetwork.jar

2. **Connecting a New Node**:
   ```bash
   java -jar target/p2pnetwork.jar

## Project Structure

 ```p2pnetwork/
│
├── src/main/java/com/example/p2pnetwork/
│   ├── App.java                  # Main application to run a node
│   ├── Node.java                 # Node class with logic for joining the network and maintaining successor/predecessor
│   ├── DHT.java                  # Distributed Hash Table implementation for storing key-value pairs
│   ├── javaUtil.java             # Utility methods for generating MAC address and hashing
│   ├── P2PServiceImpl.java       # gRPC service implementation handling node communication
│   ├── P2PClient.java            # gRPC client to interact with other nodes
│   └── P2PServiceProto.proto     # Protocol Buffers definition file for gRPC
│
└── pom.xml                       # Maven build file
 ```
## Future Improvements

1.  **Automatic Node Recovery:** Implement a mechanism to automatically redistribute the data from nodes that leave the network to ensure data persistence.
   
3.  **Advanced File Transfer Simulation:** Expand beyond ping operations to include file transfers using the DHT, simulating real-world P2P applications.
   
5.  **Load Balancing in the DHT:** Ensure that the keys are evenly distributed across the network, avoiding overloading a single node.
   
7.  **Failure Handling:** Improve resilience by detecting node failures and reorganizing the network automatically.
