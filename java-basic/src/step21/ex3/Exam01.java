package step21.ex3;

public class Exam01 {
    static void m() {
        throw new RuntimeException("예외가 발생했습니다.");
    }
    
    public static void main(String[] args) {
        try {
            m();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("시스템을 종료합니다.");
    }
}
