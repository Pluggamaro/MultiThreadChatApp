import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandle {
    private final Socket clientSocket;
    private final AppServer server;
    private PrintWriter out;
    private BufferedReader in;
    private String user;
}
