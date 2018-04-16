package step23.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StatelessClient {
    public static void main(String[] args) throws Exception {
        try(Scanner keyScan = new Scanner(System.in);){
            while (true) {
                System.out.print("값? ");
                String str = keyScan.nextLine();
                
                try(Socket socket = new Socket("localhost", 8888);
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner in = new Scanner(socket.getInputStream());){
                    
                    out.println(str);
                    if(str.equals("")) {
                        System.out.println(in.nextLine());
                        break;
                    }
                }
            }
        }
    }
}
