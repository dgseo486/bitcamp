package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_4")
public class Exam04_4 {
    
    // 테스트 방법
    // http://localhost:8888/bitcamp-spring-webmvc/exam04_4.html
    
    @PostMapping(value="post", consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public String m1() {
        return "Exam04_4.m1()";
    }
    
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody
    public String m2() {
        return "Exam04_4.m2()";
    }
    
    @PostMapping(value="post", consumes="application/json")
    @ResponseBody
    public String m3() {
        return "Exam04_4.m3()";
    }
    
}
