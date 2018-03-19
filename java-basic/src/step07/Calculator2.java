// 메서드 분류 - 클래스 변수 사용
package step07;

public class Calculator2 {
    static int result = 0;
    
    // 다음 메서드는 작업 결과를 클래스 변수에 보관한다.
    public static void plus (int value) {
        result = result + value;
    }
    public static void minus (int value) {
        result = result - value;
    }
    public static void multiple (int value) {
        result = result * value;
    }
    public static void divide (int value) {
        result = result / value;
    }
}
