package step23.ex1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender4 {
    public static void main(String[] args) throws Exception {
        File file = new File("temp/jls8.pdf");
        
        FileInputStream fileIn = new FileInputStream(file);
        
        System.out.println("서버에 연결 중...");
        Socket socket = new Socket("192.168.0.32", 8888);
        System.out.println();
        
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        out.writeLong(file.length());
        
        out.writeUTF(file.getName());
        
        int b;
        while((b = fileIn.read()) != -1) {
            out.write(b);
        }
        
        String response = in.nextLine();
        System.out.println(response);
        
        in.close();
        out.close();
        socket.close();
        fileIn.close();
    }
}
