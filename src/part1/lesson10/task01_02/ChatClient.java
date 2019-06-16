package part1.lesson10.task01_02;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient extends Thread {

    private int CLIENT_PORT;
    private String clientName;

    public int getClientPort() {
        return CLIENT_PORT;
    }

    public String getClientName() {
        return clientName;
    }

    public ChatClient(int clientPort, String name) {
        CLIENT_PORT = clientPort;
        clientName = name;
    }

    @Override
    public void run() {
        try(DatagramSocket datagramSocket = new DatagramSocket();
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            
            InetAddress inetAddress = InetAddress.getLocalHost();
            String sendMessage = bf.readLine();
            byte[] sendPacket = sendMessage.getBytes();
            byte[] receivePacket = new byte[1024];
            DatagramPacket sendDP = new DatagramPacket(sendPacket,sendPacket.length,inetAddress,ChatServer.getServerPort());
            datagramSocket.send(sendDP);
            DatagramPacket receiveDP = new DatagramPacket(receivePacket,receivePacket.length);
            datagramSocket.receive(receiveDP);
            String receiveMessage = new String(receiveDP.getData());
            System.out.println(receiveMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
