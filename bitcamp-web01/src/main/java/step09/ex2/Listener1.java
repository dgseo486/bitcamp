package step09.ex2;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener1 implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.printf("Listener1.contextInitialized() - %s\n", new Date());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.printf("Listener1.contextDestroyed() - %s\n", new Date());
    }
}
