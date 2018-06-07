package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03_1")
public class Exam03_1 {
    
    // 테스트 방법 : http://localhost:8888/bitcamp-spring-webmvc/exam03_1.html
    
    @RequestMapping("m1")
    @ResponseBody
    public String m1() {
        return "Exam03_1.m1()";
    }
}
