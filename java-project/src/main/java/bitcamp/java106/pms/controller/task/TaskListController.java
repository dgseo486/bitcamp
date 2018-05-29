package bitcamp.java106.pms.controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/list")
public class TaskListController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskListController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String teamName = request.getParameter("teamName");

        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Task> list = taskDao.selectList(team.getName());
        request.setAttribute("list", list);
        return  "/task/list.jsp";
    }
}
