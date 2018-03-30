// java.util.Hashset 클래스 사용
package step12.ex5;

import java.util.HashSet;

public class Exam03_1 {
    
    static class Member {
        String name;
        int age;
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "Member [name=" + name + "age=" + age + "]";
        }
    }
    

    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("유관순", 16);
        
        HashSet set = new HashSet();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        
        print(set);
    }
    
    static void print(HashSet set) {
        Object[] values = set.toArray();
        for(Object value : values) {
            System.out.println(value);
        }
    }
    
}
