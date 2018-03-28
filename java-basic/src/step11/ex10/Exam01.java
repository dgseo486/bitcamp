// 메서드 오버로딩(overloading) - 정의하는 규칙과 사용 규칙
package step11.ex10;

public class Exam01 {

    public static void main(String[] args) {
        // 같은 이름의 메서드가 여러 개 있을 경우,
        A.m();
        A.m(100);
        A.m("Hello");
        A.m(100, "Hello");
        A.m("Hello", 100);
        
        //A.m(3.14f);
    }

}

// 오버로딩 : 파라미터의 형식은 다르지만 같은 기능을 수행하는 메서드에 대해
//            같은 이름을 부여함으로써 프로그래밍의 일관성을 제공하기 위함.
