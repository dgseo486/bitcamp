// 클래스 - 사용 전
package step03;

public class Exam01_1 {
    public static void main(String[] args) {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;

        name = "홍길동";
        kor = 100;
        eng = 90;
        math = 80;
        sum = kor + eng + math;
        aver = sum / 3;

        System.out.printf("이름:%s\n", name);
        System.out.printf("국어:%d\n", kor);
        System.out.printf("영어:%d\n", eng);
        System.out.printf("수학:%d\n", math);
        System.out.printf("합계:%d\n", sum);
        System.out.printf("평균:%.1f\n", aver);
    }
}