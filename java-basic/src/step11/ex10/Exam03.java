// 메서드 오버로딩(overloading) - 응용2
package step11.ex10;

public class Exam03 {

    public static void main(String[] args) {
        // 다양한 파라미터 값을 받는 println();
        System.out.println(100);
        System.out.println(true);
        System.out.println("hello");
        
        Integer obj1 = Integer.valueOf(100);
        Integer obj2 = Integer.valueOf("100");
        Integer obj3 = Integer.valueOf("64", 16);
        
        System.out.printf("%d, %d, %d\n", obj1, obj2, obj3);
    }

}
