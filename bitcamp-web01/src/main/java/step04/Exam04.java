package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/exam04")
public class Exam04 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam04_test.html
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //클라이언트가 보낸 값을 꺼낼 떄는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("doGET() 호출됨!\n");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //클라이언트가 보낸 값을 꺼낼 떄는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("doPOST() 호출됨!\n");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
}
