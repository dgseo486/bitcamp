package bitcamp.java106.pms.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board/list")
public class BoardListController {

    BoardDao boardDao;
    
    public BoardListController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Board> list = boardDao.selectList();
        request.setAttribute("list", list);
        return "/board/list.jsp";
    }
}