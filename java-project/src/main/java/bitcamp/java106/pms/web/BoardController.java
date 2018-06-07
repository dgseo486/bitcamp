package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    BoardDao boardDao;
    
    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping("/form")
    public void form(/*Model model*/) {
        //model.addAttribute("프로퍼티명", "값");
    }
    
    @RequestMapping("/add")
    public String add(Board board) throws Exception {
        
        boardDao.insert(board);
        return "redirect:list";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int count = boardDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("/list{page}")
    public void list(
            @MatrixVariable(defaultValue="1") int pageNo, 
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) throws Exception {
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        List<Board> list = boardDao.selectList(params);
        map.put("list", list);
    }
    
    @RequestMapping("/update")
    public String update(Board board) throws Exception {
        
        int count = boardDao.update(board);
        if (count == 0) {
            throw new Exception("해당 게시물이 존재하지 않습니다.");
        } 
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Map<String,Object> map) throws Exception {
        Board board = boardDao.selectOne(no);
        if (board == null) {
            throw new Exception("유효하지 않은 게시물 번호입니다.");
        }
        map.put("board", board);
        return "board/view";
    }
}
