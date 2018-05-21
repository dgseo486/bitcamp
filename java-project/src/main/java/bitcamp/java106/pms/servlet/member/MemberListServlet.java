package bitcamp.java106.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
    
    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        memberDao = iocContainer.getBean(MemberDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>멤버 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>멤버 목록</h1>");
        
        try{
            List<Member> list = memberDao.selectList();
            
            out.println("<p><a href='form.html'>새회원</a></p>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>아이디</th><th>이메일</th>");
            out.println("</tr>");
            
            for(Member member : list) {
                out.println("<tr>");
                out.printf("    <td><a href='view?id=%s'>%s</a></td> <td>%s</td>\n", 
                        member.getId(), member.getId(), member.getEmail());
                out.println("</tr>");
            }
            out.println("</table>");
        } catch(Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "회원 목록조회 실패");
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
    
}