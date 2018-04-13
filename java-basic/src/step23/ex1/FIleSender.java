package step23.ex1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class FIleSender {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.0.32", 8888);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        while(true) {
            System.out.print("입력> ");
            String input = keyScan.nextLine();
            out.println(input);
            
            String str = in.nextLine();
            System.out.println(str);
            
            if(input.equals("quit")) {
                break;
            }
        }
        
        in.close();
        out.close();
        socket.close();
        keyScan.close();
    }
}
