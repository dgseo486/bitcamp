package bitcamp.java106.pms.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/member/delete")
public class MemberDeleteController {
    
    MemberDao memberDao;
    
    public MemberDeleteController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        int count = memberDao.delete(id);
        if (count == 0) {
            throw new Exception("해당 회원이 없습니다.");
        }
        return "redirect:list.do";
    }
    
}