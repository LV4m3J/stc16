package part1.lesson10.task01_02.clients;

import part1.lesson10.task01_02.ChatClient;

public class Client1 {

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient(25051,"Client1");
        chatClient.run();
    }
}
