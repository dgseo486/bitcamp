package step18.ex2;

public class Exam06 {
    static interface A {}
    static interface B {}
    static interface C {}
    
    static class D implements A, B, C {}
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam06$D");
        
        Package p = clazz.getPackage();
        System.out.println(p.getName());
    }
}
