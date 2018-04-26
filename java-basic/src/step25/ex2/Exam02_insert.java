package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam02_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("내용? ");
        String content = keyScan.nextLine();
        
        
    }
}
