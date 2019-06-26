package part1.lesson10.task01_02;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Connection extends Thread {

    /**
     * Класс содержит данные, относящиеся к конкретному подключению:
     * Имя пользователя
     * сокет
     * входной поток BufferedReader
     * выходной поток PrintWriter
     * Расширяет Thread и в методе run() получает информацию от пользователя и
     * пересылает её другим
     */

    private BufferedReader inRead;
    private PrintWriter outWrite;
    private Socket socket;
    private ServerListener serverListener;
    private List<Connection> connectionList;
    private String clientName = "";

    public Connection(Socket socket, ServerListener serverListener) {
        this.socket = socket;
        this.serverListener = serverListener;
        try {
            inRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outWrite = new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * закрываем все соединения
     */

    public void closeClientConnection() {
        try {
            outWrite.close();
            inRead.close();
            socket.close();
            connectionList.remove(this);

            if(connectionList.isEmpty()){
                serverListener.closeServer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            clientName = inRead.readLine();
            connectionList = serverListener.getConnectionList();
            synchronized (connectionList) {
                for (Connection cl : serverListener.getConnectionList()) {
                    cl.outWrite.println("Greetings " + clientName);
                }
            }

            String message = "";
            while (true) {
                message = inRead.readLine();
                if (message.equalsIgnoreCase("exit")){
                    break;
                }
                synchronized (connectionList){
                    for (Connection cl : serverListener.getConnectionList()) {
                        cl.outWrite.println(clientName + ": " + message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeClientConnection();
        }
    }
}
