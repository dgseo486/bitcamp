package step21.ex3;

import java.io.FileReader;
import java.util.Scanner;

public class Exam06_3 {
    static void m() throws Exception {
        try (Scanner keyScan = new Scanner(System.in);
                FileReader in = new FileReader("Hello.java");){
            System.out.print("입력> ");
            int value = keyScan.nextInt();
            System.out.println(value * value);
        }
    }
    
    public static void main(String[] args) {
        m();
    }
}
