package step07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step07/exam01")
public class Exam01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Exam01() {
        System.out.println("step07.Exam01() 호출!");
    }
    
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("step07.Exam01.init() 호출!");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("step07.Exam01.service() 호출!");
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Hello!");
    }
}
