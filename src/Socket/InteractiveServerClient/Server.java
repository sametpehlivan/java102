package Socket.InteractiveServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Locale;

public class Server {
    private static final int SERVER_PORT = 5000;
    public static String[] names = {"samet","burak","yasir","ousman"};
    public static String[] jobs = {"computer eng","computer science"};
    public static void main(String[] args) throws IOException {
       ServerSocket socket = new ServerSocket(SERVER_PORT);
       Socket clientSocket = socket.accept();
       System.out.println("[SERVER] CLIENT CONNECTED");
       PrintWriter serverOut = new PrintWriter(clientSocket.getOutputStream(),true);
       BufferedReader serverSocketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())) ;
       while (true)
       {
           String request = serverSocketIn.readLine();
           if (request.toLowerCase().equals("kisi")) serverOut.println(randomNameJob());
           else if (request.toLowerCase().equals("q"))
           {
               serverOut.println("exiting ...");
               serverOut.println("exiting");
               break;
           }
           else
           {
               serverOut.println("kisi yazınız");
           }
       }

    }
    public static String randomNameJob()
    {
        String s = names[(int)(Math.random() * names.length)] + " " + jobs[(int)(Math.random() * jobs.length)];
        return s;
    }

}
