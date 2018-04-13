package step22.ex7;

import java.io.FileInputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/jls8.pdf");
        BufferedInputStream in = new BufferedInputStream(fileIn);
        
        int b;
        
        long startTime = System.currentTimeMillis();
        int callCount = 0;
        while((b = in.read()) != -1) callCount++;
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        System.out.println(callCount);
        in.close();
    }
}
