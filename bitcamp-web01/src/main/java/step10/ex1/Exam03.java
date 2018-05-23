package step10.ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex1/exam03")
public class Exam03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Cookie cookie1 = new Cookie("c1", URLEncoder.encode("홍길동", "UTF-8"));
        Cookie cookie2 = new Cookie("c2", URLEncoder.encode("임꺽정", "UTF-8"));
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
    }
}
