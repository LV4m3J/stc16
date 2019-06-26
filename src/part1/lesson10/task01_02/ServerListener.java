package part1.lesson10.task01_02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerListener {

    public static final Integer SERVER_PORT = 25025;
    private ServerSocket server;
    public static InetAddress serverAddress;
    private List<Connection> connectionList = Collections.synchronizedList(new ArrayList<Connection>());

    public List<Connection> getConnectionList() {
        return connectionList;
    }

public ServerListener() {
    try {
        server = new ServerSocket(SERVER_PORT);
        serverAddress = server.getInetAddress();
        while (true) {
            Socket socket = server.accept();
            Connection conList = new Connection(socket, ServerListener.this);
            connectionList.add(conList);
            conList.start();
            System.out.println("conn started" + conList.getName());
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        closeServer();
    }
}


    public void closeServer(){
        try {
            server.close();
            if(!connectionList.isEmpty()){
                synchronized (connectionList) {
                    for (Connection sl:connectionList) {
                        sl.closeClientConnection();
                    }
                    connectionList.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
