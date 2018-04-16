package step23.ex2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 연결 중...");
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("클라이언트 연결을 기다리는 중...");
        Socket socket = ss.accept();
        System.out.println("대기 중인 플라이언트 중 한 개의 클라이언트에 대해 연결 승인!");
        
        socket.close();
        System.out.println("클라이언트와의 연결 해제!");
        ss.close();
        System.out.println("서버 종료!");
    }
}
