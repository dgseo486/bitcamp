package bitcamp.java106.pms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/auth")
public class AuthController {
    
    MemberDao memberDao;
    
    public AuthController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("saveId") String saveId, 
                        HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

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
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        request.getSession().invalidate();
        return "redirect:" + request.getContextPath();
    }
}
