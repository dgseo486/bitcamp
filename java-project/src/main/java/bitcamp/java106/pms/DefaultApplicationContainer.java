package bitcamp.java106.pms;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.java106.pms.context.ApplicationContext;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public class DefaultApplicationContainer implements ApplicationContainer {

    ApplicationContext iocContainer;
    
    public DefaultApplicationContainer() throws Exception {
        HashMap<String, Object> objMap = new HashMap<>();
        
        InputStream inputStream = Resources.getResourceAsStream("bitcamp/java106/pms/sql/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        objMap.put("SqlSessionFactory", factory);
        
        iocContainer = new ApplicationContext("bitcamp.java106.pms", objMap);
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
