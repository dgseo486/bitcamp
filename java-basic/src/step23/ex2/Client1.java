package step23.ex2;

import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버에 연결을 요청 중...");
        Socket socket = new Socket("localhost", 8888);
        System.out.println("서버에 연결됨!");
        
        socket.close();
    }
}
