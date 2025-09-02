import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class App {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 3000;
    public static void main(String[] args) throws Exception {
        
        try(
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){
            System.out.println("****************WELCOME TO THE MULTI-THREADED CHAT APP****************");
            System.out.print("YOUR PEERS WILL CHAT TO YOU SOON.");
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

            System.out.println("Connected.");
            String userInput;
            while((userInput = stdIn.readLine()) != null){
                out.println(userInput);
            }

        }catch(UnknownHostException e){
            System.err.println("Host fault " + SERVER_ADDRESS);
        }catch(IOException e){
            System.err.println("Ensure that server at " + SERVER_ADDRESS +" is running first, then start your app. \n" + e.getMessage());
        }

    }
}
