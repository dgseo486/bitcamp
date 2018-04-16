package step23.ex2;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("클라이언트 실행!");
        
        keyScan.nextLine();
        
        System.out.println("서버에 연결을 요청 중...");
        Socket socket = new Socket("localhost", 8888);
        System.out.println("서버에 연결됨!");
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("입출력 스트림 준비!");
        
        System.out.println("서버에 데이터 전송중...");
        out.println(args[0]);
        System.out.println("서버에 데이터 전송 완료!");
        
        System.out.println("서버로부터 데이터 수신 중...");
        System.out.println(in.nextLine());
        System.out.println("서버로부터 데이터 수신 완료!");
        
        socket.close();
    }
}
