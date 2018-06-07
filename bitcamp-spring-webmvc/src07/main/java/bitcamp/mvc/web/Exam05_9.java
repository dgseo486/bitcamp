package bitcamp.mvc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bitcamp.mvc.vo.Board;

@Controller
@RequestMapping("/exam05_9")
public class Exam05_9 {

    // 테스트 방법
    // http://localhost:8888/bitcamp-spring-webmvc/exam05_9.html
    @PostMapping(value="post")
    @ResponseBody
    public String m1(String name, int age, String tel) {
        return String.format("m1(): name=%s, age=%d, tel=%s", name, age, tel);
    }
    
 // 테스트 방법
    // http://localhost:8888/bitcamp-spring-webmvc/exam05_9.html
    @PostMapping(value="post", consumes="text/plain")
    @ResponseBody
    public String m2(@RequestBody String content) {
        return String.format("m2(): %s", content);
    }
    
    // 테스트 방법
    // http://localhost:8888/bitcamp-spring-webmvc/exam05_9.html
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody
    public String m3(@RequestBody String content) {
        String[] values = content.split(",");
        return String.format("m3(): name=%s, age=%s, tel=%s", values[0], values[1], values[2]);
    }
    
    // 테스트 방법
    // http://localhost:8888/bitcamp-spring-webmvc/exam05_9.html
    @SuppressWarnings("unchecked")
    @PostMapping(value="post", consumes="application/json")
    @ResponseBody
    public String m4(@RequestBody String content) {
        Map<String, Object> map = new Gson().fromJson(content, Map.class);
        
        return String.format("m4(): name=%s, age=%f, tel=%s", 
                map.get("name"), map.get("age"), map.get("tel"));
    }
    
    @PostMapping(value="post2", consumes="application/json")
    @ResponseBody
    public String m5(@RequestBody String content) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Board board = gson.fromJson(content, Board.class);
        
        return String.format("m4(): no=%d, title=%s, content=%s, createdDate=%s", 
                board.getNo(), board.getTitle(), board.getContent(), board.getCreatedDate());
    }
}
