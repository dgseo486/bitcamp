// 클래스 용도 - 사용자 정의 데이터 타입을 만들 때 사용
package step07;

public class ExamY_1 {
    public static void main(String[] args){
        int result = 0;
        
        result = Calculator.plus(2, 3);
        result = Calculator.minus(result, 1);
        result = Calculator.multiple(result, 7);
        result = Calculator.divide(result, 3);
        
        System.out.printf("result = %d\n", result);
    }
}