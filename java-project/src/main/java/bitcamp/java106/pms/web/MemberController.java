package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    MemberService memberService;
    
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    public String add(Member member) throws Exception {
        memberService.add(member);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("id") String id) throws Exception {
        int count = memberService.delete(id);
        if (count == 0) {
            throw new Exception("해당 회원이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public void list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String, Object> map) throws Exception {
        
        map.put("list", memberService.list(pageNo, pageSize));
    }
    
    @RequestMapping("update")
    public String update(Member member) throws Exception {
        int count = memberService.update(member);
        if (count == 0) {
            throw new Exception("해당 회원이 존재하지 않습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("{id}")
    public String view(@PathVariable String id, Map<String,Object> map) throws Exception {
        Member member = memberService.get(id);
        if (member == null) {
            throw new Exception("유효하지 않은 멤버 아이디입니다.");
        }
        map.put("member", member);
        return "member/view";
    }
}
