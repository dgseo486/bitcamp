package step18.ex2;

public class Exam05 {
    static interface A {}
    static interface B {}
    static interface C {}
    
    static class D implements A, B, C {}
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam05$D");
        
        Class[] list = clazz.getInterfaces();
        for(Class c : list) {
            System.out.println(c.getName());
        }
    }
}
