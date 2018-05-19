package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;


@SuppressWarnings("serial")
@WebServlet("/task/update")
public class TaskUpdateServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        this.teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        this.taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
        this.teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");
        
        try {
            Task task = new Task()
                    .setNo(Integer.parseInt(request.getParameter("no")))
                    .setTitle(request.getParameter("title"))
                    .setStartDate(Date.valueOf(request.getParameter("startDate")))
                    .setEndDate(Date.valueOf(request.getParameter("endDate")))
                    .setState(Integer.parseInt(request.getParameter("state")))
                    .setTeam(new Team().setName(request.getParameter("teamName")))
                    .setWorker(new Member().setId(request.getParameter("memberId")));
            
            int count = taskDao.update(task);
            if(count == 0) {
                throw new Exception("해당 작업이 없습니다.");
            }
            response.sendRedirect("list?teamName=" + URLEncoder.encode(teamName, "UTF-8"));
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 변경 실패!");
            요청배달자.forward(request, response);
        }
    }
}
