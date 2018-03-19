// 사용자 정의 데이터 타입 - 인스턴스 메서드
package step07;

public class ExamX_3 {
    public static void main(String[] args){
        Score3 score = new Score3();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        
        // 다음은 Score의 값을 다루기 위해 non-instance 메서드를 호출하는 예이다.
        /*
        Score2.calculate(score);
        */
        
        score.calculate();
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
                score.name, score.kor, score.eng, score.math, 
                score.sum, score.average);
    }
}