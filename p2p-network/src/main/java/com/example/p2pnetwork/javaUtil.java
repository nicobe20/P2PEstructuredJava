package com.example.p2pnetwork;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class javaUtil {
    //method to get mac addr of each node for dht key maybe, we should try something else...
    public static String getMacAddr() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            
            StringBuilder macAddress = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                macAddress.append(String.format("%02X", mac[i]));
                if (i < mac.length - 1) {
                    macAddress.append("-");
                }
            }
            return macAddress.toString();
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String HashIDNode(String input){
        try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();

            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
       
        }catch (NoSuchAlgorithmException e) {
                // Handle the error if SHA-256 is not supported
                e.printStackTrace();
                return null;
        }
    }
}