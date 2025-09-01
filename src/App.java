import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 9090;
    public static void main(String[] args) throws Exception {
        
        try{
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            

        }catch(){

        }

    }
}
