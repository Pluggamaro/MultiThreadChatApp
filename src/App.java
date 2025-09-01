import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 9090;
    public static void main(String[] args) throws Exception {
        
        try(
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){
            System.out.print("Enter username: ");
            String username = stdIn.readLine();
            out.println(username);

            //starting a new thread listenting to messages from server
            Thread serverListen = new Thread(() -> {
                String serverMsg;
                try{
                    while((serverMsg = in.readLine()) != null){
                        System.out.println(serverMsg);
                    }
                }catch(IOException e){
                    System.out.println("Connection to server lost!");
                }
            });
            serverListen.start();

            

        }catch(){

        }

    }
}
