package step23.ex5;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class StatelessClient2 {
    public static void main(String[] args) throws Exception {
        int clientId = 0;
        try(Scanner keyScan = new Scanner(System.in);){
            while (true) {
                System.out.print("값? ");
                String value = keyScan.nextLine();
                
                try(Socket socket = new Socket("localhost", 8888);
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner in = new Scanner(socket.getInputStream());){
                    
                    out.println(value);
                    out.printf("%d\n", clientId);
                    if(value.equals("")) {
                        System.out.println(in.nextLine());
                        break;
                    }
                    
                    clientId = Integer.parseInt(in.nextLine());
                }
            }
        }
    }
}
