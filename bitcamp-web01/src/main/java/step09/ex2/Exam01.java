package step09.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step09/ex2/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        request.setAttribute("이름", name);
        request.setAttribute("나이", age);
        System.out.println("---------------------------");
        
        request.setAttribute("이름", "우하하");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='UTF-8'>");
        out.println("   <title>exam01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1>exam01 실행!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        System.out.println("step09/ex2/exam01 실행!");
    }
}
