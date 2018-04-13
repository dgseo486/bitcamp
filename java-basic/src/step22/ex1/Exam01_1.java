package step22.ex1;

import java.io.FileOutputStream;

public class Exam01_1 {
    public static void main(String[] args) throws Exception{
        FileOutputStream out = new FileOutputStream("temp/test1.data");
        out.write(0x7a6b5c4d);
        out.close();
        System.out.println("데이터 출력 완료");
    }
}
