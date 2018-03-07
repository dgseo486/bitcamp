// 레퍼런스와 인스턴스 - 인스턴스 주소 주고받기
package step03;

public class Exam03_2 {
    public static void main(String[] args) {

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        Score s1 = new Score();

        Score s2 = s1;

        s1.name = "홍길동";
        
        System.out.println(s2.name);
    }
}