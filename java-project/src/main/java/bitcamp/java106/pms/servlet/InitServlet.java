package bitcamp.java106.pms.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;

@WebServlet(
        value="/initServlet", //value는 urlPatterns 와 같다.
        loadOnStartup=1)
@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
    
    static ApplicationContext iocContainer;
    
    public static ApplicationContext getApplicationContext() {
        return iocContainer;
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
