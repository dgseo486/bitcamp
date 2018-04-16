package step23.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StatefulServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        ServerSocket ss = new ServerSocket(8888);
        
        while(true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 연결 승인 및 작업 처리 중...");
            processRequest(socket);
        }
    }
    
    static void processRequest(Socket socket) throws Exception {
        try (Socket socket2 = socket;
             PrintStream out = new PrintStream(socket.getOutputStream());
             Scanner in = new Scanner(socket.getInputStream());) {
            int sum = 0;
            while(true){
                String str = in.nextLine();
                if(str.equals("")) {
                    break;
                }
                sum = sum + Integer.parseInt(str);
            }
            out.println("result = " + sum);
        }
    }
}
