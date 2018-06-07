package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03_2")
public class Exam03_2 {
    
    // 테스트 방법 : http://localhost:8888/bitcamp-spring-webmvc/exam03_2.html
    
    @RequestMapping(value="m1", method=RequestMethod.GET)
    @ResponseBody
    public String m1() {
        return "Exam03_2.m1()";
    }
    
    @RequestMapping(value="m2", method=RequestMethod.POST)
    @ResponseBody
    public String m2() {
        return "Exam03_2.m2()";
    }
}
