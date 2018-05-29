package bitcamp.java106.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board/view")
public class BoardViewController {

    BoardDao boardDao;
    
    public BoardViewController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        Board board = boardDao.selectOne(no);
        if (board == null) {
            throw new Exception("유효하지 않은 게시물 번호입니다.");
        }
        request.setAttribute("board", board);
        return "/board/view.jsp";
    }
}