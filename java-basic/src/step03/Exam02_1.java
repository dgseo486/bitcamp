// 레퍼런스 배열 - 사용 전
package step03;

public class Exam02_1 {
    public static void main(String[] args) {
        
        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }
        
        Score s1, s2, s3;
        s1 = new Score();
        s2 = new Score();
        s3 = new Score();

        s1.name = "홍길동";
        s2.name = "임꺽정";
        s3.name = "유관순";

        System.out.printf("이름: %s\n", s1.name);
        System.out.printf("이름: %s\n", s2.name);
        System.out.printf("이름: %s\n", s3.name);
        
    }
}