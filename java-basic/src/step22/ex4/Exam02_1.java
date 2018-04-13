package step22.ex4;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        DataOutputStream out = new DataOutputStream("temp/test4.data");
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        out.writeUTF(member.name);
        
        System.out.println(member);
    }
}
