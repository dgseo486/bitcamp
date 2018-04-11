package step21.ex3;

public class Exam06_4 {
    
    static class A {}
    
    static class B implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("B 클래스의 자원을 해제하였습니다.");
        }
    }
    
    static void m() throws Exception {
        try (//A obj = new A();
                B obj2 = new B();){
            System.out.println("try 블록 실행...");
        }
    }
    
    public static void main(String[] args) throws Exception {
        m();
    }
}
