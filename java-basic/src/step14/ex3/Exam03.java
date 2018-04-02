package step14.ex3;

public class Exam03 implements B, C, D {
    // B와 D의 겹치는 메소드는 어차피 구현한 메소드가 아니기 때문에 상관없다.
    public void m2() {}
    public void m1() {}
    public void m3() {}
    public void m4() {} // D의 인터페이스 구현
}
