// 변수 초기화 - 초기화 문장
package step08;

public class Exam05_2 {
    
    static class A {
        // 변수 생성 즉시 할당 연산 실행
        static int a = 100;
        int b = 200;
    }
    
    public static void main(String[] args) {
        int c = 300;
        
        System.out.println(A.a);
        
        A obj1 = new A();
        System.out.println(obj1.b);
        
        System.out.println(c);
    }
}
