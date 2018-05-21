package step08.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex1/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='UTF-8'>");
        out.println("   <meta http-equiv='Refresh' content='3;url=http://www.daum.net'>");
        out.println("   <title>exam01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1>exam01</h1>");
        out.println("   <p>3초 후에 카카오 홈페이지를 다시 요청한다.<br>");
        out.println("   일종의 페이지를 자동으로 이동하는 효과가 있다.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
