package com.example.p2pnetwork;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class javaUtil {
    //method to get mac addr of each node for dht key maybe we should try something else...
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
}
