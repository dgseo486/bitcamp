package step22.ex2;

import java.io.FileReader;

public class Exam03_2 {
    public static void main(String[] args) throws Exception{
        FileReader in = new FileReader("temp/test2.txt");
        
        char[] buf = new char[100];
        
        int count = in.read(buf, 10, 40);
        
        in.close();
        
        System.out.printf("%d\n", count);
        for(int i = 10; i < count + 10; i++) {
            System.out.printf("%c(%x) ", buf[i], (int)buf[i]);
        }
        System.out.println();
    }
}
