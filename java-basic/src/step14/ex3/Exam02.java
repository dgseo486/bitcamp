package step14.ex3;

public class Exam02 implements B, C {
    public void m2() {}
    public void m1() {} // B의 슈퍼 인터페이스의 메서드까지 구현해야 한다.
    public void m3() {} // C의 인터페이스 구현
}
