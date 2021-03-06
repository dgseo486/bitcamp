package bitcamp.java106.pms.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    BoardService boardService;
    
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    
    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    public String add(Board board) throws Exception {
        boardService.add(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int count = boardService.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public void list(
            @MatrixVariable(defaultValue="1") int pageNo, 
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) {
        
        map.put("list", boardService.list(pageNo, pageSize));
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        int count = boardService.update(board);
        if (count == 0) {
            throw new Exception("해당 게시물이 존재하지 않습니다.");
        } 
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Map<String,Object> map) throws Exception {
        Board board = boardService.get(no);
        if (board == null) {
            throw new Exception("유효하지 않은 게시물 번호입니다.");
        }
        map.put("board", board);
        return "board/view";
    }
}
