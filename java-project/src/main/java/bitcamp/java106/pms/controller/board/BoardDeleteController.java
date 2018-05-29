package bitcamp.java106.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board/delete")
public class BoardDeleteController {
    
    BoardDao boardDao;
    
    public BoardDeleteController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        int count = boardDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list.do";
    }
    
}