package part1.lesson10.task01_02;

public class MultiplayerChat {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread serverThread = new Thread(chatServer);
        serverThread.start();
    }
}

//todo Разработать приложение - многопользовательский чат, в котором участвует произвольное количество клиентов.
// Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
// Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
// a. добавить возможность отправки личных сообщений (unicast).
// b. добавить возможность выхода из чата с помощью написанной в чате команды «quit»
