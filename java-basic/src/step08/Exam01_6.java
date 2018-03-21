// 클래스 변수의 응용
package step08;

public class Exam01_6 {

    static class Member {
        // 모든 인스턴스가 다음의 변수에 대해 같은 값을 가질 경우,
        // 클래스 변수로 만드는 것이 바람직하다.
        // 값을 저장하는 것이 아닌 조회하는 용도로만 사용하는 변수라면 
        // 대문자로 선언하여 상수임을 표현한다.
        
        // 문법적으로 값을 변경하는 것을 막아라. final
        public final static int GUEST = 0;
        public final static int MEMBER = 1;
        public final static int MANAGER = 2;
        
        String id;
        String password;
        int type; // 0: 손님, 1: 회원, 2: 관리자
    }
    
    public static void main(String[] args) {
        Member m1 = new Member();
        m1.id = "aaa";
        m1.password = "1111";
        m1.type = 0;
        
        Member m2 = new Member();
        m2.id = "bbbb";
        m2.password = "1111";
        m2.type = 2;
        
        Member m3 = new Member();
        m3.id = "cccc";
        m3.password = "1111";
        m3.type = 1;
        
        // 회원 타입을 숫자로 지정했는데 시간이 지나면 숫자의 의미를 기억하기 어렵다.
        // 이런 경우를 방지하고자 나온 문법이 상수이다.
        
        Member m4 = new Member();
        m4.id = "aaa";
        m4.password = "1111";
        m4.type = Member.GUEST;
        
        Member m5 = new Member();
        m5.id = "bbbb";
        m5.password = "1111";
        m5.type = Member.MANAGER;
        
        Member m6 = new Member();
        m6.id = "cccc";
        m6.password = "1111";
        m6.type = Member.MEMBER;
    }

}
