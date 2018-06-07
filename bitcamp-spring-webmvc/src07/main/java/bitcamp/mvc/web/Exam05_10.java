package bitcamp.mvc.web;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/exam05_10")
public class Exam05_10 {
    @Autowired ServletContext sc;
    
    @PostMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, int age, MultipartFile photo) throws Exception {
        
        String filePath = sc.getRealPath("/" + photo.getOriginalFilename());
        photo.transferTo(new File(filePath));
        
        return String.format("m1(): name=%s, age=%d, photo=%s", name, age, photo.getOriginalFilename());
    }
}
