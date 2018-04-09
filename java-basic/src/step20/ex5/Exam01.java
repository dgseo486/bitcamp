package step20.ex5;

public class Exam01 {
    public static void main(String[] args) {
        Class clazz = MyClass.class;
        MyAnnotation obj = (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
        
        System.out.println(obj.v1());
        System.out.println(obj.v2());
        System.out.println(obj.v3());
    }
}
