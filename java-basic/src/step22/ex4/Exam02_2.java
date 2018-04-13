package step22.ex4;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream("temp/test4_2.data");
        
        Member member = new Member();
        
        member.name = in.readUTF();
        
        member.age = in.readInt();
        
        member.gender = in.readBoolean();
        
        in.close();
        
        System.out.println(member);
    }
}
