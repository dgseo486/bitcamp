package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam06_1")
public class Exam06_1 {
    
    @GetMapping(value="m1")
    @ResponseBody
    public String m1() {
        return "Exam06_1.m1() ==> 0123ABC#@!가각간";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() {
        return "Exam06_1.m2() ==> 0123ABC#@!가각간";
    }
}
