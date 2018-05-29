package bitcamp.java106.pms.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/member/add")
public class MemberAddController {
    
    MemberDao memberDao;
    
    public MemberAddController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));

        memberDao.insert(member);
        return "redirect:list.do";
    }
}
