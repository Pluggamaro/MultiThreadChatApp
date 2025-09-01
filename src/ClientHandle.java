import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandle implements Runnable {
    private final Socket clientSocket;
    private final AppServer server;
    private PrintWriter out;
    private BufferedReader in;
    private String user;

    public ClientHandle(Socket socket, AppServer server){
        this.clientSocket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {

            //setting streams of communication
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //given that first line is name, following returns name
            this.user = in.readLine();
            System.out.println( user+" has joined the chat.");
            server.broadcast(user + " has joined!", this );

            String activeInput;
            while((activeInput = in.readLine()) != null){
                server.broadcast(activeInput, this);
            }
        }catch(IOException e){
            System.err.println("Client error: ");
        }
    }

}
