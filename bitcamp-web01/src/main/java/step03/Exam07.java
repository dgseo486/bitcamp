package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam08")
public class Exam07 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Map<String, String[]> paramMap = request.getParameterMap();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Set<String> nameSet = paramMap.keySet();
        for (String name : nameSet) {
            out.printf("%s=", name);
            String[] values = paramMap.get(name);
            for(String value : values) {
                out.printf("%s,", value);
            }
            out.println();
        }
    }
}
