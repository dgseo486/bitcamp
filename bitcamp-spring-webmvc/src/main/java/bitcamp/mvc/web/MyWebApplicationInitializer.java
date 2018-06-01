package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("===> MyWebApplicationInitializer.onStartup()");
        
        AnnotationConfigWebApplicationContext iocContainer = new AnnotationConfigWebApplicationContext();
        iocContainer.register(AppConfig.class);
        iocContainer.refresh();
        
        DispatcherServlet mvcDispatcher = new DispatcherServlet(iocContainer);
        Dynamic registration = servletContext.addServlet("mvc", mvcDispatcher);
        registration.setLoadOnStartup(1);
        registration.addMapping("/mvc/*");
    }
    
}
