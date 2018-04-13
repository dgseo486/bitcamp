package step22.ex3;

import java.io.FileInputStream;

public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        long value = (long)in.read() << 56;
        value = value + (long)in.read() << 48;
        value = value + (long)in.read() << 40;
        value = value + (long)in.read() << 32;
        value = value + (long)in.read() << 24;
        value = value + (long)in.read() << 16;
        value = value + (long)in.read() << 8;
        value = value + (long)in.read();
        
        in.close();
        
        System.out.printf("%x\n", value);
    }
}
