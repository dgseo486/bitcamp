package bitcamp.mvc.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06_2")
public class Exam06_2 {
    
    @GetMapping(value="m1")
    public HttpEntity<String> m1() {
        HttpEntity<String> entity = new HttpEntity<>("Exam06_2.m1() ==> 0123ABC#@!가각간");
        return entity;
    }
    
    @GetMapping(value="m2")
    public HttpEntity<String> m2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        HttpEntity<String> entity = new HttpEntity<>("Exam06_2.m2() ==> 0123ABC#@!가각간", headers);
        return entity;
    }
    
    @GetMapping(value="m3")
    public ResponseEntity<String> m3() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        ResponseEntity<String> entity = 
                new ResponseEntity<>("Exam06_2.m3() ==> 0123ABC#@!가각간", headers, HttpStatus.OK);
        return entity;
    }
    
}
