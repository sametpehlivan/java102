package Socket.MultiInteraction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {
    private static final int SERVER_PORT = 5000;
    public static String[] names = {"samet","burak","yasir","ousman"};
    public static String[] jobs = {"computer eng","computer science"};
    //private static ArrayList<Socket> clients;
    // private static ClientHandler;
    private static ExecutorService pool = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(SERVER_PORT);
        while (true)
        {
            Socket clientSocket = socket.accept();
            System.out.println("[SERVER] CLIENT CONNECTED");
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            pool.execute(clientHandler);
        }

    }
    public static String randomNameJob()
    {
        String s = names[(int)(Math.random() * names.length)] + " " + jobs[(int)(Math.random() * jobs.length)];
        return s;
    }
}
