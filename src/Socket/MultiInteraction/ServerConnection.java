package Socket.MultiInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection implements Runnable
{
    private Socket socket;
    private BufferedReader input;
    public ServerConnection(Socket socket) throws IOException
    {
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                var response =  input.readLine();
                if (response == null) break;
                System.out.println(response);
            }
        }catch (IOException e)
        {
            try {
                input.close();
            }catch (IOException e2){}
        }
    }
}
