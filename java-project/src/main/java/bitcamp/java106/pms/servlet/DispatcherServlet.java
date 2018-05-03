package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;
import bitcamp.java106.pms.controller.Controller;

@WebServlet("/*")
public class DispatcherServlet implements Servlet {

    ServletConfig config;
    ApplicationContext iocContainer;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String path = request.getPathInfo();
        Controller controller = (Controller) iocContainer.getBean(path);
        
        if (controller != null) {
            controller.service(new ServerRequestAdapter(request), new ServerResponseAdapter(response));
        } else {
            out.println("해당 명령을 처리할 수 없습니다.");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "요청 처리를 중계하는 서블릿";
    }

    @Override
    public void destroy() {
        
    }
    
}
