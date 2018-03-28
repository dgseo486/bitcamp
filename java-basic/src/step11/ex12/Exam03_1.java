// Object 클래스의 메서드를 오버라이딩 하기
package step11.ex12;

public class Exam03_1 {
    
    static class Member {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        if(m1 == m2) {
            System.out.println("m1 == m2");
        } else {
            System.out.println("m1 != m2");
        }
        
        System.out.println(m1.equals(m2));
        // equals()는 String 클래스에서 문자열 비교에 사용했던 메서드이다.
        // 두 문자열이 인스턴스가 달라도 내용이 같으면 true를 리턴했다.
        // 그런데 위의 실행 결과를 보면 m1과 m2가 비록 인스턴스는 다르지만 
        // 내용이 같기 때문에 true를 리턴할 것이라 예상했는데
        // 실제 리턴 값을 확인해보면 false를 리턴한다.
        // 이유?
        // object 클래스에서 상속 받아 쓰는 equals()는 원래 내용물을 비교하는게 아니라
        // 인스턴스가 같은지를 비교하는 메서드이다.
        // m1, m2 인스턴스가 다르니 당연히 그 결과가 false인 것이다.
        
    }

}