package step18.ex1;

import java.io.File;

public class Exam03 {
    static class A {
        static int s_var = 100;
        int i_var = 200;
        
        static void s_m() {}
        void i_m() {}
        
        static {
            System.out.println("A 클래스 로딩");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = A.class;
        Class clazz2 = String.class;
        Class clazz3 = System.class;
        Class class4 = File.class;
    }
}
