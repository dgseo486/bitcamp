package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_3")
public class Exam04_3 {
    
    // 테스트 방법
    // http://localhost:8888/bitcamp-spring-webmvc/exam04_3.html
    
    @GetMapping(value="get", produces="text/plain")
    @ResponseBody
    public String m1() {
        return "Exam04_3.m1()";
    }
    
    @GetMapping(value="get", produces="text/html")
    @ResponseBody
    public String m2() {
        return "Exam04_3.m2()";
    }
    
    @GetMapping(value="get", produces="application/pdf")
    @ResponseBody
    public String m3() {
        return "Exam04_3.m3()";
    }
    
}
