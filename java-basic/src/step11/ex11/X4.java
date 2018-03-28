package step11.ex11;

public class X4 extends X3 {
    @Override
    void m1() {
        System.out.println("X4의 m1()");
    }
    
    void test() {
        this.m1();
        super.m1();
        this.m2();
        super.m2();
    }
}
