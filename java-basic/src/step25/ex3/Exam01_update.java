package step25.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam01_update {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("변경할 게시물 번호? ");
        String no = keyScan.nextLine();
        
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("내용? ");
        String startDate = keyScan.nextLine();
        
        try {
            BoardDao boardDao = new BoardDao();
            int count = stmt.executeUpdate(board);
            System.out.printf("%d 개 변경 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
