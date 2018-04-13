package step22.ex6;

import java.io.ByteArrayInputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        byte[] buf = {0x0b, 0x41, 0x42, 
                (byte)0xea, (byte)0xb0, (byte)0x80, 
                (byte)0xea, (byte)0xb0, (byte)0x81,
                (byte)0xea, (byte)0xb0, (byte)0x84, 
                0x00, 0x00, 0x00, 0x1b, 0x01};
        
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        
        Member member = new Member();
        
        int size = in.read();
        byte[] bytes = new byte[size];
        in.read(bytes);
        
        member.name = new String(bytes, "UTF-8");
        
        member.age = in.read() << 24;
        member.age += in.read() << 16;
        member.age += in.read() << 8;
        member.age += in.read();
        
        if(in.read() == 1) {
            member.gender = true;
        } else {
            member.gender = false;
        }
        
        in.close();
        
        System.out.println(member);
    }
}
