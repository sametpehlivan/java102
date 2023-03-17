package Socket.SingleInteraction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server
{
    private static final int SERVER_PORT = 5000;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("[SERVER] Client waiting");
        Socket clientSocket = serverSocket.accept();
        while (true){
            PrintWriter out =  new PrintWriter(clientSocket.getOutputStream(),true);
            out.println((new Date()).toString());
            System.out.println("[SERVER] Send Date");
            clientSocket.close();
            clientSocket = serverSocket.accept();
        }
    }
}
