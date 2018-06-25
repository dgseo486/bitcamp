package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/exam08_3")
@SessionAttributes({"name", "age"})
public class Exam08_3 {
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, Model model) {
        model.addAttribute("name", name);
        return String.format("m1(): 모델 객체를 통해서 세션에 값 넣기 - name=%s", name);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(int age, Model model) {
        model.addAttribute("age", age);
        return String.format("m2(): 모델 객체를 통해서 세션에 값 넣기 - age=%d", age);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(boolean working, Model model) {
        model.addAttribute("working", working);
        return String.format("m3(): 모델 객체를 통해서 세션에 값 넣기 - working=%b", working);
    }
}
