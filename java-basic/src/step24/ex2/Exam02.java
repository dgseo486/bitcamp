package step24.ex2;

public class Exam02 {
    
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        
        ThreadGroup group = main.getThreadGroup();
        System.out.println("실행 흐름명 = " + group.getName());
    }
}
