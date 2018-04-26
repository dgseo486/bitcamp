package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.util.List;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/list")
public class TaskListController implements Controller {
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskListController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                out.printf("'%s' 팀을 입력하시기 바랍니다.\n", teamName);
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
