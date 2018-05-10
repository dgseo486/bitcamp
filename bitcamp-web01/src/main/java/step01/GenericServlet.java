package step01;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public abstract class GenericServlet implements Servlet {
    
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    public void destroy() {
        
    }
    
    @Override
    public String getServletInfo() {
        return this.getClass().getName();
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
    
}
