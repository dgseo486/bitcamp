package bitcamp.java106.pms.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/member/list")
public class MemberListController {
    
    MemberDao memberDao;
    
    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Member> list = memberDao.selectList();
        request.setAttribute("list", list);
        return "/member/list.jsp";
    }
    
}