package bitcamp.java106.pms.web.json;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    MemberService memberService;
    
    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping("/loginUser")
    public Member loginUser(HttpSession session) {
        return (Member) session.getAttribute("loginUser");
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
        
        if (memberService.isExist(id, password)) {
            session.setAttribute("loginUser", memberService.get(id));

            String refererUrl = (String)session.getAttribute("refererUrl");
            
            if (refererUrl == null || refererUrl.contains("login.do") || refererUrl.endsWith("/auth/form.jsp")) { 
                return "redirect:/";
            } else { 
                return "redirect:" + refererUrl;
            }
            
        } else { //로그인 실패
            session.invalidate();
            return "auth/fail";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }
}
