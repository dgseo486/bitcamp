package step22.ex2;

import java.io.FileWriter;
import java.io.IOException;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter("temp/test2.txt");
        //4바이트 값을 출력하면 앞의 2바이트는 버리고, 
        //뒤의 2바이트(UTF-16)를 UTF-8 코드표에 따라 1 ~ 4 바이트 값으로 변환하여 출력한다.
        out.write(0x7a6bAC00);
        out.close();
        System.out.println("출력 완료");
    }
}
