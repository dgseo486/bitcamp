package bitcamp.java106.step12.ex3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;
import bitcamp.java106.step12.Board;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step12/ex3/application-context.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        boardDao.insert(board);
        
        List<Board> list = boardDao.selectList(1, 5);
        for(Board b : list) {
            System.out.printf("%d, %s, %s\n", 
                    b.getNo(), b.getTitle(), b.getRegisteredDate());
        }
    }
}
