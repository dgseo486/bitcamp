package step23.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        out.println(args[0]);
        
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
    }
}
