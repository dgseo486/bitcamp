package step21.ex1;

import java.util.Scanner;

public class Exam02_1 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        while(true) {
            System.out.print("입력> ");
            String op = keyScan.next();
            if(op.equalsIgnoreCase("quit")) {
                break;
            }
            int v1 = keyScan.nextInt();
            int v2 = keyScan.nextInt();
            
            
            int result = Calculator2.compute(op, v1, v2);
            if(result == -1212121212) {
                System.out.println("유효하지 않은 연산자입니다.");
            } else {
                System.out.println(result);
            }
        }
        keyScan.close();
    }
}
