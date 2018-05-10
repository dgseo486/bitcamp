package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step01/exam01")
public class Exam01 implements Servlet {
    
    ServletConfig config;
    
    public Exam01() {
        System.out.println("Exam01()");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Exam01.init()");
        this.config = config;
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Exam01.service()");
    }
    
    @Override
    public void destroy() {
        System.out.println("Exam01.destroy()");
    }
    
    @Override
    public String getServletInfo() {
        return "Exam01 서블릿!";
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
}
