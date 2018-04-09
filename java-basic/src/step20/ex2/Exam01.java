package step20.ex2;

public class Exam01 {
    public static void main(String[] args) {
        Class clazz = MyClass.class;
        
        //유지정책 => CLASS
        MyAnnotation obj = (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
        if(obj == null) {
            System.out.println("MyAnnotation을 추출할 수 없습니다.");
        }
        
        //유지정책 => SOURCE
        MyAnnotation2 obj2 = (MyAnnotation2)clazz.getAnnotation(MyAnnotation2.class);
        if(obj2 == null) {
            System.out.println("MyAnnotation을 추출할 수 없습니다.");
        }
        
      //유지정책 => RUNTIME
        MyAnnotation3 obj3 = (MyAnnotation3)clazz.getAnnotation(MyAnnotation3.class);
        if(obj3 == null) {
            System.out.println("MyAnnotation을 추출할 수 없습니다.");
        } else {
            System.out.println("MyAnnotation3.value = " + obj3.value());
        }
        
    }
}
