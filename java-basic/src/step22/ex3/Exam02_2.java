package step22.ex3;

import java.io.FileInputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        int value = in.read() << 24;
        value = value + (in.read() << 16);
        value = value + (in.read() << 8);
        value = value + in.read();
        
        in.close();
        
        System.out.printf("%x\n", value);
    }
}
