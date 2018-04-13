package step22.ex9;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test9_4.data");
        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
        ObjectOutputStream out = new ObjectOutputStream(bufOut);
        
        Member3 member = new Member3();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        out.writeObject(member);
        
        out.close();
        
        System.out.println("데이터 출력 완료");
    }
}
