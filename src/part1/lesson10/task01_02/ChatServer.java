package part1.lesson10.task01_02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ChatServer {

    private static final int SERVER_PORT = 25025;
    private static List<ClientListener> chatClientList = new LinkedList<>();

    public static int getServerPort() {
        return SERVER_PORT;
    }

    public static List<ClientListener> getChatClientList() {
        return chatClientList;
    }

    public static void main(String[] args) {
        Socket socket = null;
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            socket = serverSocket.accept();
            while (!serverSocket.isClosed()) {
                chatClientList.add(new ClientListener(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
