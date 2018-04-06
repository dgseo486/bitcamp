package step18.ex4;

import java.lang.reflect.Constructor;

public class Exam02 {
    
    public Exam02() {}
    public Exam02(int i) {}
    public Exam02(String s, int i) {}
    
    public static void main(String[] args) throws Exception {
        Class clazz = Exam02.class;
        
        Constructor c = clazz.getConstructor(int.class);
        System.out.printf("%s(%d)\n", c.getName(), c.getParameterCount());
    }
}
