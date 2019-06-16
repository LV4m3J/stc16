package part1.lesson10.task01_02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatServer {

    private static final int SERVER_PORT = 25025;

    private DatagramPacket datagramPacket;

    public static int getServerPort() {
        return SERVER_PORT;
    }

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }



}
