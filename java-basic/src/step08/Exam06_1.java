// 초기화 블록 - 인스턴스 블록
package step08;

public class Exam06_1 {
    static class A {
        int a;
        int b;
        
        { // 초기화 블록
            System.out.println("{}1");
        }
        
        A() {
            System.out.println("A()");
        }
        
        { // 여러개 생성 가능
            System.out.println("{}2");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A obj1 = new A();
    }

}
