import java.io.BufferedReader;
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
        
    }

}
