// 클래스 변수와 인스턴스 변수 생성 시점
package step08;

public class Exam01_4 {

    static class A {
        static int v1;
        int v2;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A.v1 = 100;
        
        // v2는 인스턴스 변수이기 떄문에 사용하기 전에 new 명령으로 먼저 생성해야 한다.
        //A.v2 = 200;
        
        // v2 인스턴스 변수는 인스턴스 주소를 통해 사용해야 한다.
        A p = new A();
        //A.v2 = 200;
        p.v2 = 200;
        
        A p2 = new A();
        p2.v2 = 300;
        
        System.out.printf("A.v1=%d, p.v2=%d, p2.v2=%d\n", 
                A.v1, p.v2, p2.v2);
    }

}
