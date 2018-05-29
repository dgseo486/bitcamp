package bitcamp.java106.pms.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/member/view")
public class MemberViewController {

    MemberDao memberDao;

    public MemberViewController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        Member member = memberDao.selectOne(id);
        if (member == null) {
            throw new Exception("유효하지 않은 멤버 아이디입니다.");
        }
        request.setAttribute("member", member);
        return "/member/view.jsp";
    }
}