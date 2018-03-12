// 흐름 제어문 - 조건문 if에 여러 문장을 묶기
package step05;

public class Exam01_2 {
    public static void main(String[] args) {
        int age = 17;

        // 블록으로 묶지 않으면 첫 번째 문장만 if에 종속된다.
        if (age >= 19) 
            System.out.println("성인이다."); // 이 문장만 if에 소속된다.
            System.out.println("군대 가야한다.");
            System.out.println("일해야 한다.");
            System.out.println("세금 납부해야 한다.");
        
        System.out.println("-------------------------------------------");
        
        // 여러 문장을 if 문에 종속시킬 수 있다.
        if (age >= 19) {
            System.out.println("성인이다.");
            System.out.println("군대 가야한다.");
            System.out.println("일해야 한다.");
            System.out.println("세금 납부해야 한다.");
        }

    }
}