package step25.ex3;

import java.util.List;

public class Exam01_list {
    public static void main(String[] args) throws Exception {
        BoardDao boardDao = new BoardDao();
        
        try {
            List<Board> list = boardDao.list();
            
            for(Board board : list) {
                System.out.printf("%d, %s, %s\n", board.getNo(), board.getTitle(), board.getRegisteredDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
