package step13.ex2;

import step11.ex12.Member;

public class Exam01_2 {
    public static void main(String[] args) {
        LinkedList2<Member> list = new LinkedList2<>();
        list.add(new Member("홍길동", 20));
        list.add(new Member("임꺽정", 30));
        list.add(new Member("유관순", 16));
        
        for(int i = 0; i < list.size(); i++) {
            Member member = list.get(i);
            System.out.printf("%s(%d)\n", member.name, member.age);
        }
    }
}
