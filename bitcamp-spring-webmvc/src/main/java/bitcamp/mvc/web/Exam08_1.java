package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam08_1")
public class Exam08_1 {
    @GetMapping(value="m1/{value}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(@PathVariable String value) {
        return String.format("m1(): value=%s", value);
    }
    
    @GetMapping(value="m2/{team:t[a-zA-Z]+}-{member:m[a-z0-9]+}-{doc:[0-9]+}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @PathVariable String team,
            @PathVariable String member,
            @PathVariable int doc) {
        return String.format("m2(): team=%s, member=%s, doc=%d", team, member, doc);
    }
}
