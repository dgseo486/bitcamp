package step11.ex05;

// B 클래스는 단지 A 클래스의 링크 정보만 갖고 있다.
// 따라서 B 클래스를 사용하려면 반드시 A 클래스가 있어야 한다.
public class B extends A {
    int v2;
    
    static {
        System.out.println("B 클래스의 static {} 실행");
    }
}
