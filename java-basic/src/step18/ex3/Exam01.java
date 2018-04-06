package step18.ex3;

import java.lang.reflect.Method;

public class Exam01 {
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) {
        Class clazz = Exam01.class;
        
        Method[] list = clazz.getMethods();
        for(Method m : list) {
            System.out.println(m.getName());
        }
    }
}
