package part1.lesson10.task01_02.clients;

import part1.lesson10.task01_02.ChatClient;

public class Client2 {
    public static void main(String[] args) {
        ChatClient cc2 = new ChatClient(25052,"client2");
        cc2.run();
    }
}
