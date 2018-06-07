package bitcamp.mvc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exam05_7")
public class Exam05_7 {

    @GetMapping(value="m1")
    public String m1(Map<String, Object> map) {
        map.put("name", "홍길동");
        map.put("age", 20);
        return "/exam05_7.jsp";
    }
    
    @GetMapping(value="m2")
    public String m2(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        return "/exam05_7.jsp";
    }
    
    @GetMapping(value="m3")
    public ModelAndView m3() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "홍길동");
        mv.addObject("age", 20);
        mv.setViewName("/exam05_7.jsp");
        return mv;
    }
    
}
