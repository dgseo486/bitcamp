package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step04/exam01")
public class Exam01 extends GenericServlet {
    private static final long serialVersionUID = 1L;
    
    // 테스트 방법
    // http://localhost:8888/bitcamp-web01/step04/exam01_test.html
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //클라이언트가 보낸 값을 꺼낼 떄는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
}
