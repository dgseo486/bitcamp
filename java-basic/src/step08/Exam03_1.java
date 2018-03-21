// 내장 변수 this
package step08;

public class Exam03_1 {
    static class A {
        int value;
        
        static void m1() {
            //this.value = 100;
        }
        void m2() {
            this.value = 100;
        }
        void m3() {
            this.value = 200; // 인스턴스 변수를 사용할 때 this를 생략할 수 있다.
            value = 200;
        }
        void m4(int value) {
            // 로컬 변수의 이름이 인스턴스 이름과 같을 경우
            // this를 붙이지 않으면 로컬 변수를 가리킨다.
            value = 200; // 로컬 변수
            this.value = 300; // 인스턴스 변수이다.
        }
    }
    public static void main(String[] args) {
        A.m1();
        
        A obj1 = new A();
        
        obj1.m2();
        
        // 클래스 메서드도 레퍼런스를 가지고 호출할 수 있지만,
        // 인스턴스 주소가 메서드에 전달되는 것은 아니다.
        // 그래서 클래스 메서드는 this라는 내장 변수가 없다.
        obj1.m1();
        
        A obj2 = new A();
        
        obj2.m2();
    }
}
