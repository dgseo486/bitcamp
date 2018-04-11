package step21.ex3;

import java.util.Scanner;

public class Exam06_1 {
    static void m() {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        int value = keyScan.nextInt();
        System.out.println(value * value);
        keyScan.close();
    }
    
    public static void main(String[] args) {
        m();
    }
}
