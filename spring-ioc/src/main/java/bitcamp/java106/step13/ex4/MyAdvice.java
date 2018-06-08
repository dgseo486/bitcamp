package bitcamp.java106.step13.ex4;

public class MyAdvice {
    
    public void doBefore(int a, int b) {
        System.out.printf("MyAdvice.doBefore(): %d, %d\n", a, b);
    }
    
    public void doAfterReturning(Object returnValue) {
        System.out.printf("MyAdvice.doAfterReturning(): %d\n", returnValue);
    }
    
    public void doAfterThrowing(Exception error) {
        System.out.printf("MyAdvice.doAfterThrowing(): %s\n", error.getMessage());
    }
    
}
