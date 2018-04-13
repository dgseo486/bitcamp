package step23.ex1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.0.32", 8888);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        out.println("서도경입니다. 안녕하세요");
        
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        
        socket.close();
    }
}
