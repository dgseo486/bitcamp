// 메서드 분류 - 인스턴스 변수
package step07;

public class ExamY_4 {
    public static void main(String[] args){
        // 계산 결과를 개별적으로 관리하고 싶은가?
        // 관리할 변수를 인스턴스 변수로 선언한다.
        Calculator3 c1 = new Calculator3();
        Calculator3 c2 = new Calculator3();
        
        Calculator3.plus(c1, 2);
        Calculator3.plus(c2, 3);
        
        Calculator3.plus(c1, 1);
        Calculator3.multiple(c2, 2);
        
        Calculator3.minus(c1, 1);
        Calculator3.plus(c2, 7);
        
        Calculator3.multiple(c1, 7);
        Calculator3.divide(c2, 4);
        
        Calculator3.divide(c1, 3);
        Calculator3.minus(c2, 5);
        
        System.out.printf("result = %d, result = %d\n", c1.result, c2.result);
    }
}