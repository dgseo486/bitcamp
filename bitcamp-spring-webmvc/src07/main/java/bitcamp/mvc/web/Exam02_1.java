package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.dao.BoardDao;

@Controller
@RequestMapping("/exam02_1")
public class Exam02_1 {
    
    BoardDao boardDao;
    ServletContext servletContext;
    
    public Exam02_1(BoardDao boardDao, ServletContext servletContext) {
        this.boardDao = boardDao;
        this.servletContext = servletContext;
    }
    
    @RequestMapping("m1")
    @ResponseBody
    public String m1() {
        return this.servletContext.getContextPath();
    }
}
