package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("web.HelloController")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "/hello.jsp";
    }
}
