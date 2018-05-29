package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;
import bitcamp.java106.pms.web.RequestMapping;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    
    @Override
    public void init() throws ServletException {
        try {
            iocContainer = 
                    new ClassPathXmlApplicationContext(
                            this.getServletConfig().getInitParameter("contextConfigLocation"));
            
            WebApplicationContextUtils.containers.put(this.getServletContext(), iocContainer);
            
            String[] beanNames = iocContainer.getBeanDefinitionNames();
            System.out.println("-----------------------------");
            for (String name : beanNames) {
                System.out.println(name);
            }
            System.out.println("-----------------------------");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String servletPath = request.getServletPath().replace(".do", "");
        try {
            Object pageController = iocContainer.getBean(servletPath);
            Method requestHandler = findRequestHandler(pageController);
            if(requestHandler == null) {
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");
            }
            
            String viewUrl = (String)requestHandler.invoke(pageController, request, response);
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!");
        }
    }
    
    private Method findRequestHandler(Object pageController) throws Exception {
        Class<?> clazz = pageController.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null) {
                return m;
            }
        }
        return null;
    }
}
