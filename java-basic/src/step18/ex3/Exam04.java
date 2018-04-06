package step18.ex3;

import java.lang.reflect.Method;

public class Exam04 {
    public void m1() {}
    public void m2(String s) {}
    public void m3(String s, int i) {}
    
    public static void main(String[] args) throws Exception {
        Class clazz = Exam04.class;
        
        System.out.println(clazz.getMethod("m1").getName());
        
        Class parameterType = String.class;
        Method m = clazz.getMethod("m2", parameterType);
        System.out.println(m.getName());
        
        parameterType = Class.forName("java.lang.String");
        m = clazz.getMethod("m2", parameterType);
        System.out.println(m.getName());
        
        Class intType = int.class;
        Class stringType = String.class;
        m = clazz.getMethod("m3", stringType, intType);
        System.out.println(m.getName());
    }
}
