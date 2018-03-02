// 부동소수점 리터럴(literal) - 크기
package step01;

public class Exam06_2 {
    public static void main(String[] args) {
        // 부동소수점도 크기에 따라 작성하는 방법이 다르다.
        System.out.println(3.14); // 8바이트 크기의 부동소수점
        
        // 부동소수점 뒤에 F나 f를 붙이면 4바이트 크기의 부동소수점으로 다룬다.
        System.out.println(3.14f); // 4바이트 크기의 부동소수점

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);

        // 4byte 부동소수점 테스트
        System.out.println("----------------------------------");
        System.out.println(987.6543f);
        System.out.println(987654.3f);
        System.out.println(9.876543f);

        // 4byte 메모리 범위를 넘어가는 부동소수점이기 때문에 값이 짤린다.
        System.out.println(987654.345678f);
        System.out.println(98765434567.8f);
        System.out.println(9.87654345678f);

        // 8byte 부동소수점 테스트
        System.out.println("----------------------------------");
        System.out.println(987.6543);
        System.out.println(987654.3);
        System.out.println(9.876543);

        // 8byte 메모리 범위 안에서 표현 가능한 부동소수점이기 때문에 정상출력된다.
        System.out.println(987654.345678);
        System.out.println(98765434567.8);
        System.out.println(9.87654345678);

        System.out.println("----------------------------------");
        System.out.println(7 * 0.1);
        // 결과 0.7000000000000001
        // IEEE 754 규격에 따라 부동소수점을 이진수로 바꾸는 과정에서 정확하게
        // 2진수로 딱 떨어지지 않는 경우가 있다.
    }
}