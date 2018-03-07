// 클래스 사용 - 패키지 클래스 사용
package step03;

public class Exam04_1 {
    public static void main(String[] args) {

        //바깥 쪽에 별도로 선언한 클래스 사용하기
        Score s1 = new Score();
        s1.name = "홍길동";
        System.out.println(s1.name);
    }
}