package part1.lesson10.task01_02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public ChatClient(){
        Scanner scaner = new Scanner(System.in);
        try {
            socket = new Socket("127.0.0.1",ChatServer.SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Введите свой ник:");
            out.write(scaner.nextLine());

            ClientListener clientListener = new ClientListener(in);
            clientListener.start();

            String message = "";
            while (!message.equalsIgnoreCase("exit")) {
                message = scaner.nextLine();
                out.write(message);
            }
            clientListener.setStop();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
