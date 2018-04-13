package step22.ex3;

import java.io.FileOutputStream;

public class Exam01_1 {
    public static void main(String[] args) throws Exception{
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        int money = 1_3456_7890; // 0x080557d2
        
        out.write(money);
        
        out.close();
        
        System.out.println("데이터 출력 완료");
    }
}
