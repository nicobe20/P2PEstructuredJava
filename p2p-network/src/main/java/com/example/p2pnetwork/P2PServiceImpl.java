package com.example.p2pnetwork;
import com.example.p2pnetwork.P2PServiceProto.*;
import io.grpc.stub.StreamObserver;


public class P2PServiceImpl extends P2PServiceGrpc.P2PServiceImplBase {

    @Override
    public void simulateFileTransfer(FileTransferRequest request, StreamObserver<FileTransferResponse> responseObserver){
        //Parameters for file transfer
        String fileName = request.getFilename();
        String fileSize = request.getFileSize();
        String senderNode = request.getSenderNode();
        String receiverNode = request.getReceiverNode();

        //Simulate here the file transfer 
        System.out.println("transfer from " + senderNode + "and receiving " + receiverNode);
        System.out.println("Filename " + fileName + "File size " + fileSize);

        FileTransferResponse response = FileTransferResponse.newBuilder()
        .setStatus("Transfer Completed ").setDetails("Filename: "+fileName+ " Recieved from: "+senderNode+" File Size: "+fileSize).build(); //the parameters here to the build can be alter or expanded for better simulation
        //resp
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}

    /* TESTING.
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        // Extract the message from the request
        String message = request.getMessage();
        System.out.println("Received: " + message);

        // Build a response message
        MessageResponse response = MessageResponse.newBuilder()
                .setConfirmation("Message received: " + message)
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
         
    }
}
    */