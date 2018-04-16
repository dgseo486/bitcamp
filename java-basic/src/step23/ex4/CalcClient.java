package step23.ex4;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        while(true) {
            Socket socket = new Socket("localhost", 8888);
            Scanner in = new Scanner(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            System.out.print("값1? ");
            int a = Integer.parseInt(keyScan.nextLine());
            
            System.out.print("연산자? ");
            String op = keyScan.nextLine();
            
            System.out.print("값2? ");
            int b = Integer.parseInt(keyScan.nextLine());
            
            out.writeInt(a);
            out.writeUTF(op);
            out.writeInt(b);
            
            String str = in.nextLine();
            System.out.println(str);
            
            in.close();
            out.close();
            socket.close();
        }
    }
}
