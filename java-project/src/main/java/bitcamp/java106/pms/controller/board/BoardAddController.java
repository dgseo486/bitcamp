package bitcamp.java106.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board/add")
public class BoardAddController {
    
    BoardDao boardDao;
    
    public BoardAddController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        boardDao.insert(board);
        return "redirect:list.do";
    }
    
}