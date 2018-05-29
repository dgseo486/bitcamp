package bitcamp.java106.pms.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/member/update")
public class MemberUpdateController {
    
    MemberDao memberDao;

    public MemberUpdateController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));

        int count = memberDao.update(member);
        if (count == 0) {
            throw new Exception("해당 회원이 존재하지 않습니다.");
        }
        return "redirect:list.do";
    }
}