package step10.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex2/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("c1", "aaa");
        cookie1.setMaxAge(20);
        
        Cookie cookie2 = new Cookie("c2", "bbb");
        cookie2.setMaxAge(40);
        
        Cookie cookie3 = new Cookie("c3", "ccc");
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
    }
}
