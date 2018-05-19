package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/list")
public class TeamListServlet extends HttpServlet {
    
    TeamDao teamDao;

    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>팀 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>팀 목록</h1>");
        
        try {
            List<Team> list = teamDao.selectList();
            
            out.println("<p><a href='form.html'>새 팀</a></p>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>팀명</th><th>최대인원</th><th>기간</th>");
            out.println("</tr>");
            
            for (Team team : list) {
                out.println("<tr>");
                out.printf("    <td><a href='view?name=%s'>%s</a></td><td>%d</td><td>%s~%s</td>\n",
                        team.getName(),
                        team.getName(),
                        team.getMaxQty(), 
                        team.getStartDate(), 
                        team.getEndDate());
                out.println("</tr>");
            }
            out.println("</table>");
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 목록조회 실패");
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }

}