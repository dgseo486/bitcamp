package step18.ex2;

public class Exam01 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.String");
        
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getTypeName());
    }
}
