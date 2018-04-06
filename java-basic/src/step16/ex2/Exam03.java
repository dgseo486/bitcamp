package step16.ex2;

import java.net.URL;

public class Exam03 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.bitcamp.co.kr/a/b/c.html#footer");
        
        System.out.printf("프로토콜: %s\n", url.getProtocol());
        System.out.printf("서버주소: %s\n", url.getHost());
        System.out.printf("포트번호: %d\n", url.getPort());
        System.out.printf("자원경로: %s\n", url.getPath());
        System.out.printf("참조경로(내부위치): %s\n", url.getRef());
    }
}
