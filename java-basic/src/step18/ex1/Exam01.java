package step18.ex1;

class A {
    static int i;
    static void m() {
        i = 100;
    }
    static {
        System.out.println("A 클래스 로딩");
    }
}

public class Exam01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //A.i = 100; // 클래스 로딩 확인
        //A.m(); // 클래스 로딩 확인
        //new A(); // 클래스 로딩 확인
        
        Class.forName("step18.ex1.A");
        
        //A obj = null;
        //A[] arr;
        //arr = new A[100];
    }
}
