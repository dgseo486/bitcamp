package step22.ex2;

import java.io.FileReader;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test2.txt");
        
        //JVM에 설정된 문자코드표에 따라 바이트를 읽어서 UTF-16으로 바꾼 후에 리턴한다.
        //리턴 값은 2바이트 UTF-16의 코드 값이다.
        
        //EA B0 80 이라는 3바이트가 들어가지만 read()를 통해 변환된다.
        //결과 : ac00
        int ch = in.read();
        in.close();
        System.out.printf("%x\n", ch);
    }
}
