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
@RequestMapping("/exam05_5")
public class Exam05_5 {

    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1(): %s, %s, %s", title, content, createdDate);
    }
    
    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("Exam05_5().initBinder()");
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(Date.valueOf(text));
            }
        });
    }
    */
}
