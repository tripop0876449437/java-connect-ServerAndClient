package client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public static void main(String[] args) throws IOException {
    System.out.println("#Client started..");
    Socket socket = new Socket("127.0.0.1", 22222);
    System.out.println("#Client Connected..");
        // I/O set socket
        ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream OIS = new ObjectInputStream(socket.  getInputStream());
        int start=0,round=3;
            System.out.println("***The limit for Sending and Receiving is  "+round+" rounds.***");
        for(;start<round;start++){
            try{
                // send to server
                System.out.print("Client: ");
                Scanner sc = new Scanner(System.in);
                String SendMessage = sc.nextLine();
                OOS.writeObject(SendMessage);
                //receive from server
                Object ReceiveServer = OIS.readObject();
                System.out.println("Server: "+ReceiveServer);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}