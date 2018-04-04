// 제네릭 사용 후

package step13.ex1;

import java.util.ArrayList;

import step11.ex12.Member;

public class Exam01_2 {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("홍길동", 20));
        
        //list.add(new String("Hello"));
        //list.add(new Integer(100));
        //list.addAll(new HashSet());
        
        Member member = (Member) list.get(0);
        System.out.println(member.name);
        System.out.println(member.age);
        
    }
}
