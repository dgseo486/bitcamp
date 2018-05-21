package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/view")
public class TeamViewServlet extends HttpServlet {
    
    TeamDao teamDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        teamDao = iocContainer.getBean(TeamDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>팀 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>팀 보기</h1>");
        
        try {
            Team team = teamDao.selectOne(name);
            System.out.println(team);
            if (team == null) {
                throw new Exception("유효하지 않은 팀입니다.");
            }
            
            out.println("<form action='update' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.printf("    <th>팀명</th><td><input type=\"text\" name=\"name\" value='%s' readonly></td>\n", team.getName());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>설명</th><td><textarea name=\"description\" ");
            out.printf("        rows=\"6\" cols=\"60\">%s</textarea></td>\n", team.getDescription());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>최대인원</th><td><input type=\"number\" name=\"maxQty\" value='%d'></td>\n", team.getMaxQty());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>시작일</th><td><input type=\"date\" name=\"startDate\" value='%s'></td>\n", team.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>종료일</th><td><input type=\"date\" name=\"endDate\" value='%s'></td>\n", team.getEndDate());
            out.println("</tr>");
            out.println("</table>");
            out.println("<p>");
            out.println("<a href='list'>목록</a>");
            out.println("<button>변경</button>");
            out.printf("<a href='delete?name=%s'>삭제</a>\n", name);
            out.printf("<a href='../task/list?teamName=%s'>작업목록</a>\n", name);
            out.println("</p>");
            out.println("</form>");
            
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/team/member/list");
            요청배달자.include(request, response);
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 상세조회 실패!");
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }

}