package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public class DefaultApplicationContainer implements ApplicationContainer {

    ApplicationContext iocContainer;
    
    public DefaultApplicationContainer() throws Exception {
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }
    
    @Override
    public String execute(String requestURI) {
        ServerRequest request = new ServerRequest(requestURI);
        
        StringWriter memoryWriter = new StringWriter();
        PrintWriter out = new PrintWriter(memoryWriter);
        ServerResponse response = new ServerResponse(out);
        
        String path = request.getServerPath();
        Controller controller = (Controller) iocContainer.getBean(path);
        
        if (controller != null) {
            controller.service(request, response);
        } else {
            out.println("해당 명령을 처리할 수 없습니다.");
        }
        
        return memoryWriter.toString();
    }
    
}
