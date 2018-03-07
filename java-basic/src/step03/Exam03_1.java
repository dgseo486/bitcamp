// 레퍼런스와 인스턴스 - 가비지
package step03;

public class Exam03_1 {
    public static void main(String[] args) {

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        Score s1;

        s1 = new Score(); // 주소를 읽어버린다.(가비지)

        s1 = new Score();
    }
}