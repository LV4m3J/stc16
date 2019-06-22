package part1.lesson10.task01_02;

import java.io.*;
import java.net.Socket;

public class ClientListener extends Thread {

    private Socket socket;
    private BufferedReader bufferedSocketReader;
    private BufferedWriter bufferedSocketWriter;

    public ClientListener(Socket socket) throws IOException {
        this.socket = socket;
        bufferedSocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedSocketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();

    }

    @Override
    public void run() {
        String message;

        try {
            while (true){
                message = bufferedSocketReader.readLine();
                if(message.equals("exit")) {
                    break;
                }
                for (ClientListener cl : ChatServer.getChatClientList()) {
                    if(cl.equals(this)){
                        continue;
                    } else {
                        cl.send(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(String message) throws IOException {
        bufferedSocketWriter.write(message);
        bufferedSocketWriter.newLine();
        bufferedSocketWriter.flush();
    }
}
