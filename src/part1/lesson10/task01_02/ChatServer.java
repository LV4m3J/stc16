package part1.lesson10.task01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

    public static final int SERVER_PORT = 25025;


    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message;
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
