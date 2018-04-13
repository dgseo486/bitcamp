package step22.ex1;

import java.io.FileInputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test1.data");
        int b = in.read();
        in.close();
        System.out.printf("%x\n", b);
    }
}
