package step18.ex5;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Exam01 {
    
    public void m1(String name, int age) {}
    public void m2() {}
    public void m3(File file, String name) {}
    
    public static void main(String[] ok) {
        Class clazz = Exam01.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods) {
            System.out.printf("%s:\n", m.getName());
            
            Parameter[] parameters = m.getParameters();
            for(Parameter p : parameters) {
                System.out.printf("    %s:%s\n", p.getName(), p.getType().getName());
            }
        }
        
    }
}
