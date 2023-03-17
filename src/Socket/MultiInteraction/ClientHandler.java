package Socket.MultiInteraction;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    private static int count;
    static
    {
        count = 0;
    }
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;
    private int id;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public ClientHandler(Socket client) throws IOException
    {
        ClientHandler.count++;
        this.id = count;
        this.client = client;
        ClientHandler.clients.add(this);
        this.input = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
        this.output = new PrintWriter(this.client.getOutputStream(),true);
    }
    @Override
    public void run() {
            try{
                while(true)
                {
                    String request = input.readLine();
                    if(request.contains("-anyone"))
                    {
                        output.println(Server.randomNameJob());
                    }
                    else if(request.contains("-everyone"))
                    {
                        int index = request.indexOf(" ");
                        if(index != -1)
                        {
                            String message = request.substring(index+1);
                            this.sendAll(message);
                        }
                    }
                    else if (request.contains("-end"))
                    {
                        output.println("Bye...");
                        output.close();
                        ClientHandler.clients.remove(this);
                        break;
                    }
                    else
                    {
                        output.println("Unexcepted token");
                    }

                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
    }
    private void sendAll(String message){
        ClientHandler.clients.forEach(c-> { if(! c.equals(this)) c.output.println(this+message); else c.output.println("[You] " + message); });
    }
    @Override
    public String toString()
    {
        return "[Client "+this.id+"]: ";
    }
}
