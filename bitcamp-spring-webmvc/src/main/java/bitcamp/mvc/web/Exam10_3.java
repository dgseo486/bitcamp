//JSON 데이터 출력하기 - 스프링 설정과 잭슨 라이브러리로 JSON  데이터 출력하기
package bitcamp.mvc.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

@RestController
@RequestMapping("/exam10_3")
public class Exam10_3 {
    
    BoardDao boardDao;
    
    public Exam10_3(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping(value="list")
    @ResponseBody
    public Object list() {
        List<Board> boards = boardDao.selectList();
        return boards;
    }
}
