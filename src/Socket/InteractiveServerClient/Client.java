package Socket.InteractiveServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5000;
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader clientSocketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter clientSocketOut = new PrintWriter(clientSocket.getOutputStream(),true);

        BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("[CLIENT] ");
            String request =  consoleIn.readLine();
            clientSocketOut.println(request);
            if (request.equals("q")) break;
            String response = clientSocketIn.readLine();
            System.out.println("[SERVER] " + response);
        }
        clientSocketOut.close();
        clientSocketIn.close();
        clientSocket.close();
        consoleIn.close();
        System.exit(0);

    }
}
