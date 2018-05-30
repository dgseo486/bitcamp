package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;
import bitcamp.java106.pms.web.RequestMapping;
import bitcamp.java106.pms.web.RequestParam;

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
        int index = servletPath.lastIndexOf('/');
        String objName = servletPath.substring(0, index);
        String handlerPath = servletPath.substring(index);
        try {
            Object pageController = iocContainer.getBean(objName);
            Method requestHandler = findRequestHandler(pageController, handlerPath);
            if(requestHandler == null) {
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");
            }
            
            HashMap<String, Object> resultMap = new HashMap<>();
            
            Object[] paramValues = prepareParamValues(requestHandler, request, response, resultMap);
            
            String viewUrl = (String)requestHandler.invoke(pageController, paramValues);
            
            Set<String> keySet = resultMap.keySet();
            for(String key : keySet) {
                request.setAttribute(key, resultMap.get(key));
            }
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
            
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!");
        }
    }
    
    private Object[] prepareParamValues(
                Method requestHandler,
                HttpServletRequest request,
                HttpServletResponse response,
                HashMap<String,Object> resultMap) {
        
        ArrayList<Object> paramValues = new ArrayList<>();
        Parameter[] params = requestHandler.getParameters();
        
        for (Parameter p : params) {
            if (p.getType() == Map.class) {
                paramValues.add(resultMap);
            } else if (p.getType() == HttpServletRequest.class) {
                paramValues.add(request);
            } else if (p.getType() == HttpServletResponse.class) {
                paramValues.add(response);
            } else if (p.getType() == HttpSession.class) {
                paramValues.add(request.getSession());
            } else if (isPrimitiveType(p.getType())) {
                paramValues.add(getRequestParamValue(p, request));
            } else {
                paramValues.add(getValueObject(p, request));
            }
        }
        
        return paramValues.toArray();
    }

    private Object getValueObject(Parameter p, HttpServletRequest request) {
        Class<?> clazz = p.getType();
        
        try {
            Constructor<?> defaultConstructor = clazz.getConstructor();
            Object valueObject = defaultConstructor.newInstance();
            
            Method[] methods = clazz.getMethods();
            
            for(Method m : methods) {
                if(!m.getName().startsWith("set")) {
                    continue;
                }
                String propName = getPropertyName(m.getName());
                String propValue = request.getParameter(propName);
                System.out.printf("===> %s = %s\n", propName, propValue);
                
                if(propValue == null) {
                    continue;
                }
                Class<?> setterParamType = m.getParameterTypes()[0];
                if(!isPrimitiveType(setterParamType)){
                    continue;
                }
                
                m.invoke(valueObject, toPrimitiveValue(propValue, setterParamType));
            }
            return valueObject;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private String getPropertyName(String methodName) {
        StringBuffer buf = new StringBuffer(methodName.substring(3));
        buf.setCharAt(0, Character.toLowerCase(buf.charAt(0)));
        return buf.toString();
    }

    private Object getRequestParamValue(Parameter p, HttpServletRequest request) {
        RequestParam anno = p.getAnnotation(RequestParam.class);
        String paramName = anno.value();
        String value = request.getParameter(paramName);
        if (value == null) {return null;}
        return toPrimitiveValue(value, p.getType());
    }
    
    private Object toPrimitiveValue(String value, Class<?> type) {
        if (type == byte.class) {return Byte.parseByte(value);}
        if (type == short.class) {return Short.parseShort(value);}
        if (type == long.class) {return Long.parseLong(value);}
        if (type == int.class) {return Integer.parseInt(value);}
        if (type == float.class) {return Float.parseFloat(value);}
        if (type == double.class) {return Double.parseDouble(value);}
        if (type == char.class) {return value.charAt(0);}
        if (type == boolean.class) {return Boolean.parseBoolean(value);}
        if (type == Date.class) {return Date.valueOf(value);}
        
        return value;
    }
    
    private boolean isPrimitiveType(Class<?> type) {
        if(type == byte.class ||
           type == short.class ||
           type == int.class ||
           type == long.class ||
           type == float.class ||
           type == double.class ||
           type == char.class ||
           type == boolean.class ||
           type == String.class ||
           type == Date.class) {
            return true;
        }
        return false;
    }

    private Method findRequestHandler(Object pageController, String handlerPath) throws Exception {
        Class<?> clazz = pageController.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null && anno.value().equals(handlerPath)) {
                return m;
            }
        }
        return null;
    }
}
