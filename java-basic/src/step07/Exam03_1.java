// 사용자 정의 데이터 타입 - 인스턴스 메서드
package step07;

public class Exam03_1 {
    public static void main(String[] args){
        Score3 score = new Score3();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        
        Score2.calculate(score);
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
                score.name, score.kor, score.eng, score.math, 
                score.sum, score.average);
    }
}