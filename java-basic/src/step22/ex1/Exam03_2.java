package step22.ex1;

import java.io.FileInputStream;

public class Exam03_2 {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("temp/test1.data");
        byte[] buf = new byte[100];
        
        int count = in.read(buf, 10, 40);
        
        in.close();
        
        System.out.printf("%d\n", count);
        for(int i = 10; i < (count + 10); i++) {
            System.out.printf("%x ", buf[i]);
        }
        System.out.println();
    }
}
