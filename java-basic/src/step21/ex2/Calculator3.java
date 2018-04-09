package step21.ex2;

public class Calculator3 {
    public static int compute(String op, int a, int b) {
        switch (op) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
        case "/":
            return a / b;
        case "%":
            return a % b;
        default:
            throw new RuntimeException("해당 연산자를 지원하지 않습니다.");
        }
    }
}
