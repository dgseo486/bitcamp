// 초기화 블록 - 초기화 순서
package step08;

public class Exam06_3 {
    
    static class A {
        // 1. 인스턴스 변수 생성 및 할당 연산자 실행(초기화 문장 실행)
        int a = 100;
        
        
        // 3. 
        A() {
            a = 300;
        }
        
        
        // 2. 
        {
            a = 200;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A obj1 = new A();
        System.out.println(obj1.a);
    }
}
