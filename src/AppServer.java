import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AppServer {
    private static final int PORT = 9090;

    private final Set<ClientHandle> clientHandler = new CopyOnWriteArraySet<>();
    
    public void start(){
        
    }

}
