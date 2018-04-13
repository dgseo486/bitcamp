package step22.ex5;

public class Exam03_1 {
    public static void main(String[] args) throws Exception{
        BufferedInputStream in = new BufferedInputStream("temp/jls8.pdf");
        
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
