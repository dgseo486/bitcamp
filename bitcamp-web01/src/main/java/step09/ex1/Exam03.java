package step09.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//web.xml에 배치 정보 설정
//@WebServlet("/step09/ex1/exam03")
public class Exam03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='UTF-8'>");
        out.println("   <title>exam03</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1>exam03 실행!</h1>");
        ServletConfig config = this.getServletConfig();
        String name = config.getInitParameter("name");
        String age = config.getInitParameter("age");
        
        out.printf("<p>name=%s, age=%s</p>\n", name, age);
        
        out.println("</body>");
        out.println("</html>");
    }
}
