package step11.ex11;

public class D2 extends D {
    @Override
    void m() {
        System.out.println("D2의 m()");
    }
    
    void test() {
        this.m();
        super.m();
    }
}
