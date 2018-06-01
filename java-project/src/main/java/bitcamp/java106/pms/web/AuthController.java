package bitcamp.java106.pms.web;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    MemberDao memberDao;
    
    public AuthController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/login")
    public String login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam(value="saveId", required=false) String saveId,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception {
        
        Cookie cookie = null;
        if (saveId != null) {
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else { 
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        
        Member member = memberDao.selectOneWithPassword(params);
        
        if (member != null) {
            session.setAttribute("loginUser", member);

            String refererUrl = (String)session.getAttribute("refererUrl");
            
            if (refererUrl == null || refererUrl.contains("login.do") || refererUrl.endsWith("/auth/form.jsp")) { 
                return "redirect:/";
            } else { 
                return "redirect:" + refererUrl;
            }
            
        } else {
            session.invalidate();
            return "/auth/fail.jsp";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }
}
