package bitcamp.java106.pms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
        
        WebApplicationContextUtils.containers.put(sce.getServletContext(), iocContainer);
    }
}
