package step18.ex3;

import java.lang.reflect.Method;

public class Exam02 {
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) {
        Class clazz = Exam02.class;
        
        Method[] list = clazz.getDeclaredMethods();
        for(Method m : list) {
            System.out.println(m.getName());
        }
    }
}
