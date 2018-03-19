// 클래스 변수의 단점
package step07;

public class ExamY_3 {
    public static void main(String[] args){
        // 클래스 변수는 오직 한 개만 존재하기 때문에
        // 여러 개의 작업을 분리하여 진행할 수 없다.
        Calculator2.plus(2);
        Calculator2.plus(3);
        Calculator2.minus(1);
        Calculator2.multiple(7);
        Calculator2.divide(3);
        System.out.printf("result = %d\n", Calculator2.result);
    }
}