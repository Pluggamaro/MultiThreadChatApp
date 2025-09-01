import java.io.IOException;
import java.net.ServerSocket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AppServer {
    private static final int PORT = 9090;

    private final Set<ClientHandle> clientHandler = new CopyOnWriteArraySet<>();
    
    public void start(){
        //informing of port number
        System.out.println("Server started on port: " + PORT);
        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Server start success! Awaiting connections...");
            

        }catch(IOException w){
            System.err.println("Server error: " + w.getMessage());
        }
    }

}
