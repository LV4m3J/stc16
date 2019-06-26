package part1.lesson10.task01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private BufferedReader inRead;
    private PrintWriter outWrite;
    private Socket socket;

    public Client() {
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket("127.0.0.1", ServerListener.SERVER_PORT);
            inRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outWrite = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("Enter u nickname: ");
            outWrite.println(scanner.nextLine());

            ClientMessageSender cms = new ClientMessageSender(inRead,outWrite);
            cms.start();

            String message = "";
            while (!message.equalsIgnoreCase("exit")){
                message = scanner.nextLine();
                outWrite.println(message);
            }
            cms.setStoped(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeClient();
        }
    }

    private void closeClient() {
        try {
            inRead.close();
            outWrite.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
