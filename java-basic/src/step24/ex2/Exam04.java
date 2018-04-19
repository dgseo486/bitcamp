package step24.ex2;

public class Exam04 {
    
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();
        
        ThreadGroup[] groups = new ThreadGroup[100];
        int count = mainGroup.enumerate(groups, false);
        
        System.out.println("main 그룹에 소속된 스레드들:");
        for(int i = 0; i < count; i++) {
            System.out.println("   => " + groups[i].getName());
        }
    }
}
