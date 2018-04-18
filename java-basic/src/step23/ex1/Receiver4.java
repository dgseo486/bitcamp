package step23.ex1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver4 {
    
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트가 연결됨.");

        PrintStream out = new PrintStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        System.out.println("클라이언트로부터 데이터 수신 중...");
        
        long filesize = in.readLong();
        
        String filename = in.readUTF();
        
        File file = new File("temp/ok_" + filename);
        FileOutputStream fileOut = new FileOutputStream(file);
        
        for(long i = 0; i < filesize; i++) {
            fileOut.write(in.read());
        }
        
        System.out.println("클라이언트로부터 데이터 수신 완료!");
        
        out.println("OK!");

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
        fileOut.close();
    }
}