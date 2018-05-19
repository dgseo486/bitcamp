package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/list")
public class TaskListServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>작업 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1><a href='../team/view?name=%s'>%s</a>의 작업 목록</h1>\n", teamName, teamName);
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                throw new Exception(teamName + "  팀은 존재하지 않습니다.");
            }
            List<Task> list = taskDao.selectList(team.getName());
            
            out.printf("<p><a href='add?teamName=%s'>새작업</a></p>\n", teamName);
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>");
            out.println("</tr>");
            
            for (Task task : list) {
                out.println("<tr>");
                out.printf("    <td>%d</td>", task.getNo());
                out.printf("    <td><a href='view?no=%d'>%s</a></td>", task.getNo(), task.getTitle());
                out.printf("    <td>%s ~ %s</td>", task.getStartDate(), task.getEndDate());
                out.printf("    <td>%s</td>\n", (task.getWorker() == null) ? "-" : task.getWorker().getId());
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 목록조회 실패!");
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}
