package step23.ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender5 {
    public static void main(String[] args) throws Exception {
        File file = new File("temp/jls8.pdf");
        
        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file));
        
        System.out.println("서버에 연결 중...");
        Socket socket = new Socket("localhost", 8888);
        System.out.println("서버에 연결 완료!");
        
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
        
        System.out.println("서버에 데이터 송신 중...");
        out.writeLong(file.length());
        
        out.writeUTF(file.getName());
        
        int b;
        while((b = fileIn.read()) != -1) {
            out.write(b);
        }
        out.flush();
        System.out.println("서버에 데이터 송신 완료!");
        
        String response = in.nextLine();
        System.out.println(response);
        
        in.close();
        out.close();
        socket.close();
        fileIn.close();
    }
}
