package bitcamp.java106.pms.controller.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;

@Component("/auth/login")
public class LoginController implements PageController {
    
    MemberDao memberDao;
    
    public LoginController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Cookie cookie = null;
        if (request.getParameter("saveId") != null) {
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else {
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);

        Member member = memberDao.selectOneWithPassword(id, password);

        HttpSession session = request.getSession();

        if (member != null) {
            session.setAttribute("loginUser", member);
            String refererUrl = (String) session.getAttribute("refererUrl");
            if (refererUrl == null) {
                return "redirect:" + request.getContextPath();
            } else {
                return "redirect:" + refererUrl;
            }

        } else {
            session.invalidate();
            return "/auth/fail.jsp";
        }

    }
}
