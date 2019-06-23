package part1.lesson10.task01_02;

import java.io.*;
import java.net.Socket;

public class ServerListener extends Thread {

    /**
     * Класс содержит данные, относящиеся к конкретному подключению:
     * имя пользователя
     * сокет
     * входной поток BufferedReader
     * выходной поток PrintWriter
     * Расширяет Thread и в методе run() получает информацию от пользователя и пересылает её другим
     */

    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private String name;

    public ServerListener(Socket socket) {

        this.socket = socket;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
    }

    void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            name = in.readLine();
            String message = "";
            while (true){
                message = in.readLine();
                if(message.equalsIgnoreCase("exit")){
                    break;
                }
                for (ServerListener sl : ChatServer.connections) {
                    sl.out.write(name + ": " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}

//todo Разработать приложение - многопользовательский чат, в котором участвует произвольное количество клиентов.
// Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
// Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
// a. добавить возможность отправки личных сообщений (unicast).
// b. добавить возможность выхода из чата с помощью написанной в чате команды «quit»
