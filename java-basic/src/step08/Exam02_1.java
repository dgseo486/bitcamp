// 클래스 변수와 인스턴스 변수 응용
package step08;

public class Exam02_1 {
    static class A {
        // 클래스 메서드
        static void m1() {
            System.out.println("m1()");
        }
        
        // 인스턴스 메서드
        void m2() {
            System.out.println("m2()");
        }
    }
    
    public static void main(String[] args) {
        // 클래스 메서드 호출
        A.m1();
        
        // 인스턴스 메서드는 클래스 이름으로 호출할 수 없다.
        //A.m2();
        
        A obj1 = new A();
        //obj1.m1(); // 클래스 메서드를 인스턴스 주소를 사용하여 호출할 수 있지만,
                     // 인스턴스 메소드로 착각할 수 있다.
        obj1.m2();
        
        //A obj2 = null;
        //obj2.m2(); //NullPointerException Error
    }
}
