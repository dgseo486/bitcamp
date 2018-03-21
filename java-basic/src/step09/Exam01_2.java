// 생성자 활용 예 - java.util.Date의 생성자
package step09;

import java.util.Date;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        // Date() 기본 생성자는 메모리를 오늘 날짜 값으로 초기화시킨다.
        Date d1 = new Date();
        System.out.println(d1);
        
        // 년, 월, 일 값으로 날짜 인스턴스를 초기화시킨다.
        Date d2 = new Date(118, 2, 20);
        System.out.println(d2);
        
        // 1970년 1월 1일 0시 0분 0초부터 측정된 밀리초를 가지고 날짜 인스턴스 초기화
        Date d3 = new Date(1000l * 60 * 60 * 24 * 365 * 50);
        System.out.println(d3);
    }
}
