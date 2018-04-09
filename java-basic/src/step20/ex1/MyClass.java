package step20.ex1;

@MyAnnotation(value = "값") // 클래스 앞 선언
public class MyClass {
    @MyAnnotation(value="값") // 변수 앞 선언
    int i;
    
    @MyAnnotation(value="값") // 메서드 앞 선언
    public void m(@MyAnnotation(value="값")String p) {
        @MyAnnotation(value="값") int local;
        
        // 일반 문장 앞 선언 불가능
        //@MyAnnotation(value="값") if(true) System.out.println("ok");
    }
}
