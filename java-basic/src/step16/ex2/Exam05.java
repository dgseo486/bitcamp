package step16.ex2;

import java.net.URL;

public class Exam05 {
    public static void main(String[] args) throws Exception {
        // 윈도우 로컬 파일 경로
        URL url = new URL("file:///c:/workspace/bitcamp/java-basic/src/Hello.java");
        
        System.out.printf("프로토콜: %s\n", url.getProtocol());
        System.out.printf("서버주소: %s\n", url.getHost());
        System.out.printf("포트번호: %d\n", url.getPort());
        System.out.printf("자원경로: %s\n", url.getPath());
        System.out.printf("참조경로(내부위치): %s\n", url.getRef());
        System.out.printf("쿼리스트링: %s\n", url.getQuery());
    }
}
