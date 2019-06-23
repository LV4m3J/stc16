package part1.lesson10.task01_02;


import java.io.BufferedReader;
import java.io.IOException;

public class ClientListener extends Thread{
    /**
     * Класс в отдельной нити пересылает все сообщения от сервера в консоль.
     *
     */

    private boolean stop;
    private BufferedReader in;

    public void setStop() {
        this.stop = true;
    }
     public ClientListener(BufferedReader in){
        this.in = in;
     }

    @Override
    public void run() {
        try {
            while (!stop) {
                String message = in.readLine();
                System.out.println(message);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при получении сообщения.");
            e.printStackTrace();
        }
    }

}
