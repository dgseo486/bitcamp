package bitcamp.java106.pms.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

public class WebApplicationContextUtils {
    public static Map<ServletContext, ApplicationContext> containers = new HashMap<>();
    
    public static ApplicationContext getWebApplicationContext(ServletContext ctx) {
        return containers.get(ctx);
    }
    
}
