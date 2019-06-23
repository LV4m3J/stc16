package part1.lesson10.task01_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    public static final int SERVER_PORT = 25025;
    static List<ServerListener> connections = new ArrayList<>();
    private ServerSocket serverSocket;
    public List<ServerListener> getConnections() {
        return connections;
    }

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            while (true){
                Socket socket = serverSocket.accept();
                ServerListener conn = new ServerListener(socket);
                connections.add(conn);
                conn.start();
                if(connections.size() == 0){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }

    }

    private void closeAll() {
        try {
            serverSocket.close();
            for (ServerListener sl : connections) {
                sl.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
