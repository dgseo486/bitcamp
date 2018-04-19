package step24.ex2;

public class Exam05 {
    
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();
        
        ThreadGroup parentGroup = mainGroup.getParent();
        System.out.println(parentGroup.getName());
        
        ThreadGroup grandparentGroup = parentGroup.getParent();
        if(grandparentGroup != null) {
            System.out.println(grandparentGroup.getName());
        }
        
        
    }
}
