package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                out.printf("'%s' 팀명을 입력하시기 바랍니다.\n", teamName);
                return;
            }
            
            List<Task> list = taskDao.selectList(team.getName());
            
            for(Task task : list) {
                out.printf("%d,%s,%s,%s,%s\n", 
                        task.getNo(), task.getTitle(), 
                        task.getStartDate(), task.getEndDate(),
                        (task.getWorker() == null) ?  "-" : task.getWorker().getId());
            }
        } catch (Exception e) {
            out.println("목록 가져오기 실패!");
            e.printStackTrace(out);
        }
    }
}
