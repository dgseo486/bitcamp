package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Member;

@Controller
@RequestMapping("/exam05_4")
public class Exam05_4 {
    
    // 테스트 방법 : http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_4/m1?title=aaa&content=bbb&createdDate=2018-02-26
    
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1(): %s, %s, %s", title, content, createdDate);
    }
    
    // 테스트 방법 : http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_4/m2?member=hong,hong@test.com,password=1111
    
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(@RequestParam Member member) {
        return String.format("m2(): id=%s, email=%s, password=%s", 
                member.getId(), member.getEmail(), member.getPassword());
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("Exam05_4().initBinder()");
        
        binder.registerCustomEditor(
                java.sql.Date.class, new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(Date.valueOf(text));
                    }
                });
        
        binder.registerCustomEditor(
                bitcamp.mvc.vo.Member.class, new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        System.out.println(text);
                        String[] values = text.split(",");
                        Member obj = new Member();
                        obj.setId(values[0]);
                        obj.setEmail(values[1]);
                        obj.setPassword(values[2]);
                        this.setValue(obj);
                    }
                });
    }
}
