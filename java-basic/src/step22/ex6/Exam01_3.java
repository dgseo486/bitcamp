package step22.ex6;

public class Exam01_3 {
    public static void main(String[] args) throws Exception {
        byte[] buf = {0x0b, 0x41, 0x42, 
                (byte)0xea, (byte)0xb0, (byte)0x80, 
                (byte)0xea, (byte)0xb0, (byte)0x81,
                (byte)0xea, (byte)0xb0, (byte)0x84, 
                0x00, 0x00, 0x00, 0x1b, 0x01};
        
        ByteArrayDataInputStream in = new ByteArrayDataInputStream(buf);
        
        Member member = new Member();
        
        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        in.close();
        
        System.out.println(member);
    }
}
