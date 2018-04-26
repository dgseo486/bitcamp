package step25.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        Board board = new Board();
        
        System.out.print("제목? ");
        board.setTitle(keyScan.nextLine());
        
        System.out.print("내용? ");
        board.setContent(keyScan.nextLine());
        
        try {
            BoardDao boardDao = new BoardDao();
            int count = boardDao.insert(board);
            System.out.printf("%d 개 입력 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}
