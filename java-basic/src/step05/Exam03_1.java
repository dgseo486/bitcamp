// 흐름 제어문 - 반복문 while
package step05;

public class Exam03_1 {
    public static void main(String[] args) {
        int count = 0;
        // 조건이 참인 동안 문장 출력
        while (count < 5)
            System.out.println(count++);
        

        System.out.println("----------------------------------");
        // 여러개 문장을 반복 실행하려면 블록으로 묶어라
        count = 0;
        while (count < 5) {
            System.out.println(count);
            count++;
        }
    }
}