package bitcamp.java106.pms.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    
    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        memberDao = iocContainer.getBean(MemberDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Cookie cookie = null;
        if(request.getParameter("saveId") != null) {
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else {
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);

        try {
            Member member = memberDao.selectOneWithPassword(id, password);

            HttpSession session = request.getSession();
            
            if(member != null) {
                session.setAttribute("loginUser", member);
                String refererUrl = (String)session.getAttribute("refererUrl");
                if(refererUrl == null) {
                    response.sendRedirect(request.getContextPath());
                } else {
                    response.sendRedirect(refererUrl);
                }
                return;
                
            } else {
                session.invalidate();
                response.setContentType("text/html;charset=UTF-8");
                request.getRequestDispatcher("/auth/fail.jsp").include(request, response);
            }

        } catch (Exception e){
            request.setAttribute("error", e);
            request.setAttribute("title", "로그인 실패");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
