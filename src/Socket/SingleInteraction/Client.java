package Socket.SingleInteraction;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client
{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5000;
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = buffer.readLine();
        JOptionPane.showMessageDialog(null,response,"SERVER RESPONSE",
                JOptionPane.INFORMATION_MESSAGE,null);
        socket.close();
        System.exit(0);
    }
}
