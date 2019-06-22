package part1.lesson10.task01_02;


import java.io.*;
import java.net.Socket;

public class ChatClient {

    private String ipAddrClient;
    private int portClient;
    Socket socket;

    public ChatClient(String ipAddrClient, int portClient) {
        this.ipAddrClient = ipAddrClient;
        this.portClient = portClient;

        try(BufferedReader inputFromConsole = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader messageIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter messageOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            socket = new Socket(ipAddrClient,portClient);

            System.out.println("Enter u nickname - ");
            String userName = inputFromConsole.readLine();
            messageOut.write(userName);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

