package step17.ex3;

public class Exam02 {
    
    int value;
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void test() {
        Inner innerObj = new Inner();
        innerObj.m();
    }
    
    class Inner{
        public void m() {
            System.out.println(Exam02.this.value);
        }
    }
    
    // Inner 클래스도 Exam02의 인스턴스 멤버이기 때문에
    // Inner 클래스 안에서는 Exam02의 모든 인스턴스멤버에 접근할 수 있다.
    
    public static void main(String[] args) {
        Exam02 obj = new Exam02();
        obj.setValue(100);
        
        obj.test();
    }
}
