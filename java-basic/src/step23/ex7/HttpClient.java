package step23.ex7;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.quasarzone.co.kr", 80);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        out.println("GET /bbs/board.php?bo_table=qc_qsz&wr_id=151162 HTTP/1.1");
        out.println("Host: www.quasarzone.co.kr");
        out.println();
        
        while(true) {
            try {
                System.out.println(in.nextLine());
            } catch (Exception e) {
                break;
            }
        }
        
        out.close();
        in.close();
        socket.close();
    }
}
