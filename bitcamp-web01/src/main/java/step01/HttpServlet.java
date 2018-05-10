package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        
        this.service(httpRequest, httpResponse);
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getMethod();
        
        switch (command) {
        case "GET": doGet(request, response); break;
        case "POST": doPost(request, response); break;
        case "HEAD": doHead(request, response); break;
        default:
            throw new ServletException("해당 명령을 처리할 수 없습니다.");
        }
        
    }

    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당 명령을 처리할 수 없습니다.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당 명령을 처리할 수 없습니다.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당 명령을 처리할 수 없습니다.");
    }
    
}
