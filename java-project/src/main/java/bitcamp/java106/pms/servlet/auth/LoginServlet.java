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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("id")) {
                    id = cookie.getValue();
                    break;
                }
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>로그인</h1>");
        out.println("<form action='login' method='post'>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.printf("   <th>아이디</th><td><input type='text' name='id' value='%s'></td>\n", id);
        out.println("</tr>");
        out.println("<tr>");
        out.println("   <th>암호</th><td><input type='password' name='password'></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<p><input type='checkbox' name='saveId'>아이디 저장</p>");
        out.println("<button>로그인</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Cookie cookie = null;
        if(request.getParameter("saveId") != null) {
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60*60*24*7);
        } else {
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);

        try {
            Member member = memberDao.selectOneWithPassword(id, password);

            HttpSession session = request.getSession();
            
            if(member != null) {
                response.sendRedirect(request.getContextPath());
                session.setAttribute("loginUser", member);
            } else {
                session.invalidate();
                
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                String refererUrl = request.getHeader("Referer");
                if(refererUrl != null) {
                    out.printf("<meta http-equiv='Refresh' content='5;url=%s'>", request.getContextPath() + "/auth/login");
                }
                out.println("<title>로그인</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>로그인 실패!</h1>");
                out.println("<p>아이디 또는 암호가 맞지 않습니다.</p>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e){
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "회원 등록 실패");
            요청배달자.forward(request, response);
        }
    }
}
