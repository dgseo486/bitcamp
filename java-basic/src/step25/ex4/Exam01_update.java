package step25.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam01_update {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        Board board = new Board();
        
        System.out.print("변경할 게시물 번호? ");
        String no = keyScan.nextLine();
        
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("내용? ");
        String startDate = keyScan.nextLine();
        
        try {
            DataSource dataSource = new DefaultDataSource(
                    "com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            BoardDao boardDao = new BoardDao(dataSource);
            int count = boardDao.update(board);
            System.out.printf("%d 개 변경 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
