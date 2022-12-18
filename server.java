import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class server {
  public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("#Server started..");
        // Check port to Client connect with Server
        Socket socket = serverSocket.accept();
        System.out.println("#Client connected..");
        // I/O set socket
        ObjectInputStream OIS = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
        int start=0,round=3;
            System.out.println("***The limit for Receiving and Sending is "+round+" rounds.***");
        for(;start<round;start++){    
            try{
                //receive from client
                Object ReceiveClient = OIS.readObject();
                System.out.println("Client: " + ReceiveClient);
                //send to client
                System.out.print("Server: ");                
                Scanner sc = new Scanner(System.in);
                String SendMessage = sc.nextLine();
                OOS.writeObject(SendMessage);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}