import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AppServer {
    private static final int PORT = 9090;

    private final Set<ClientHandle> clientHandlers = new CopyOnWriteArraySet<>();
    
    public void start(){
        //informing of port number
        System.out.println("Server started on port: " + PORT);
        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Server start success! Awaiting connections...");
            while(true){
                //accepting new client
                //blocks off others until success

                Socket clientSocket = socket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                //creating new client handles starting on a new thread
                ClientHandle clientHandler =  new ClientHandle(clientSocket, this);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();

            }

        }catch(IOException w){
            System.err.println("Server error: " + w.getMessage());
        }
    }

    //method broadcasts message to all except sender
    public void broadcast(String broadcastMessage, ClientHandle sender){
        for(ClientHandle client : clientHandlers){
            if(client != sender){
                client
            }
        }
    }

}
