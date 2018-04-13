package step22.ex3;

import java.io.FileInputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        int value = in.read();
        
        in.close();
        
        System.out.printf("%x\n", value);
    }
}
