package part1.lesson10.task01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientMessageSender extends Thread {

    /**
     * Класс в отдельной нити пересылает все сообщения от сервера в консоль.
     * Работает пока не будет вызван метод setStop().
     */

    private BufferedReader inRead;
    private PrintWriter outWrite;
    private boolean stoped;

    public ClientMessageSender(BufferedReader inRead, PrintWriter outWrite) {
        this.inRead = inRead;
        this.outWrite = outWrite;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    @Override
    public void run() {
        try {
            while (!stoped) {
                String message = inRead.readLine();
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
