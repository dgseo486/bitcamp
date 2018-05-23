package step10.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex3/exam03")
public class Exam03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        session.invalidate();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("세션을 무효화하였습니다.");
    }
}
