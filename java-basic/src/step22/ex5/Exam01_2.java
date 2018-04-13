package step22.ex5;

import java.io.FileInputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        
        byte[] buf = new byte[8196];
        
        int count = 0;
        
        long startTime = System.currentTimeMillis();
        int callCount = 0;
        while((count = in.read(buf)) != -1) callCount++;
        
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        System.out.println(callCount);
        in.close();
    }
}
