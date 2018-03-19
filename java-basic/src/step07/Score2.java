// 사용자 정의 데이터 타입 - 메서드(=연산자)의 활용
package step07;

public class Score2 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    // 사용자 정의 데이터 타입의 연산자를 사용자가 정의했다.
    public static void calculate(Score2 score) {
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f;
    }
}
