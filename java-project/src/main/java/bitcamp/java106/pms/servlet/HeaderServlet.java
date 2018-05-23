package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java106.pms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        
        out.println("<div id='header'>");
        if(loginUser != null) {
            out.printf("    %s\n", loginUser.getId());
            out.printf("<a href = '%s/auth/logout'>로그아웃</a>", request.getContextPath());
        } else {
            out.printf("<a href = '%s/auth/login'>로그인</a>", request.getContextPath());
        }
        out.println("</div>");
    }
}
