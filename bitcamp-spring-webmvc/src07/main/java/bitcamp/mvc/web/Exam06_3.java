package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/exam06_3")
public class Exam06_3 {
    @GetMapping(value="m1")
    public String m1() {
        return "/exam06_3.jsp";
    }
    
    @GetMapping(value="m2")
    public View m2() {
        return new JstlView("/exam06_3.jsp");
    }
    
    @GetMapping(value="m3")
    public View m3() {
        return new RedirectView("../exam06_1/m1");
    }
    
    @GetMapping(value="m4")
    public String m4() {
        return "redirect:../exam06_1/m2";
    }
    
    @GetMapping(value="m5")
    public ModelAndView m5() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "홍길동");
        mv.addObject("age", 20);
        mv.setViewName("/exam06_3.jsp");
        return mv;
    }
}
