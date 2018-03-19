// 클래스 변수(=스태틱 변수)
package step08;

public class Exam01_3 {

    static class A {
        static int v1;
        static boolean v2;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A.v1 = 100;
        A.v2 = true;
        
        System.out.printf("%d, %b\n", A.v1, A.v2);
    }

}
