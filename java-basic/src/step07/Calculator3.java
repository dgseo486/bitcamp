// 메서드 분류 - 클래스 변수 사용
package step07;

public class Calculator3 {
    int result = 0;
    
    // 다음 메서드는 작업 결과를 클래스 변수에 보관한다.
    public static void plus (Calculator3 calc, int value) {
        calc.result = calc.result + value;
    }
    public static void minus (Calculator3 calc, int value) {
        calc.result = calc.result - value;
    }
    public static void multiple (Calculator3 calc, int value) {
        calc.result = calc.result * value;
    }
    public static void divide (Calculator3 calc, int value) {
        calc.result = calc.result / value;
    }
}
