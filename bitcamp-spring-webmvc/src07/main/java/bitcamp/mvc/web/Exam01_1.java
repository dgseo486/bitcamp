package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam01_1/m1")
public class Exam01_1 {
    @RequestMapping
    @ResponseBody
    public String m1() {
        return "Exam01_1.m1()";
    }
}
