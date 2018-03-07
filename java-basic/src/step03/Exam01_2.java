// 클래스 - 사용 후
package step03;

public class Exam01_2 {
    public static void main(String[] args) {
        
        // 다양한 타입의 메모리를 묶어서
        // Score라는 새로운 형태의 메모리를 만들 수 있는 설계도.
        // 개발자가 새롭게 정의한 데이터 타입이다.
        // "사용자 정의 데이터타입"이라 부른다.
        // 클래스 문법을 사용하여 설계도를 정의한다.
        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        // 개발자가 새롭게 정의한 메모리 설계도에 따라 메모리를 준비한다.
        // Score 설계도에 따라 메모리를 확보하라.
        // 주소를 보관하기 위해 레퍼런스 필요
        Score s; // Score 설계도에 따라 주소를 저장할 변수 선언
        s = new Score(); // Score 설계도에 따라 메모리 확보하고
                         //그 메모리의 주소를 s에 저장한다.

        s.name = "홍길동";
        s.kor = 100;
        s.eng = 90;
        s.math = 80;
        s.sum = s.kor + s.eng + s.math;
        s.aver = s.sum / 3;

        System.out.printf("이름:%s\n", s.name);
        System.out.printf("국어:%d\n", s.kor);
        System.out.printf("영어:%d\n", s.eng);
        System.out.printf("수학:%d\n", s.math);
        System.out.printf("합계:%d\n", s.sum);
        System.out.printf("평균:%.1f\n", s.aver);
    }
}