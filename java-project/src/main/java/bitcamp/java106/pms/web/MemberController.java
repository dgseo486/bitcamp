package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;

@Component("/member")
public class MemberController {
    
    MemberDao memberDao;
    
    public MemberController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/add")
    public String add(Member member) throws Exception {
        memberDao.insert(member);
        return "redirect:list.do";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") String id) throws Exception {
        int count = memberDao.delete(id);
        if (count == 0) {
            throw new Exception("해당 회원이 없습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(Map<String,Object> map) throws Exception {
        List<Member> list = memberDao.selectList();
        map.put("list", list);
        return "/member/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Member member) throws Exception {
        int count = memberDao.update(member);
        if (count == 0) {
            throw new Exception("해당 회원이 존재하지 않습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/view")
    public String view(@RequestParam("id") String id, Map<String,Object> map) throws Exception {
        Member member = memberDao.selectOne(id);
        if (member == null) {
            throw new Exception("유효하지 않은 멤버 아이디입니다.");
        }
        map.put("member", member);
        return "/member/view.jsp";
    }
}
