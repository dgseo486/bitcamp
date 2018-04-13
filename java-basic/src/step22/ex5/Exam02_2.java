package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_3.pdf");
        
        byte[] buf = new byte[8196];
        int count = 0;
        long startTime = System.currentTimeMillis();
        
        while((count = in.read(buf)) != -1) {
            out.write(buf, 0, count);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        
        in.close();
        out.close();
    }
}
