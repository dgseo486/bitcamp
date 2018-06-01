package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Exam01 {
    @RequestMapping("/exam01/m1")
    @ResponseBody
    public String m1() {
        return "Hello!";
    }
}
