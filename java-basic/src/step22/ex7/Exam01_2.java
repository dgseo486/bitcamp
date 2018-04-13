package step22.ex7;

import java.io.FileInputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test7.data");
        DataInputStream in = new DataInputStream(fileIn);
        
        Member member = new Member();
        
        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        in.close();
        
        System.out.println(member);
    }
}
