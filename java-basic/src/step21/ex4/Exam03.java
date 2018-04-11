package step21.ex4;

public class Exam03 {
    
    static void m1() {
        m2();
    }
   
    static void m2() {
        m3();
    }
    
    static void m3() {
        m4();
    }
    
    static void m4() {
        // 구체적으로 예외 처리할 경우 throws Exception이 필요없다.
        throw new RuntimeException("m4()에서 예외 발생");
    }
    
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
