// 클래스 메서드 응용
package step08;

import java.util.Scanner;

public class Exam02_2 {
    static class Math {
        public static int abs(int value) {
            if(value < 0) {
                return value * -1;
            }
            return value;
        }
    }
    
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("숫자를 입력하세요> ");
        int value = keyScan.nextInt();
        
        int result = Math.abs(value);
        System.out.printf("절대값=%d\n", result);
    }
}
