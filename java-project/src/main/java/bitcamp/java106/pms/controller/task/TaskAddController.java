package bitcamp.java106.pms.controller.task;

import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/add")
public class TaskAddController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    public TaskAddController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String teamName = request.getParameter("teamName");

        Task task = new Task();
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startDate")));
        task.setEndDate(Date.valueOf(request.getParameter("endDate")));
        task.setTeam(new Team().setName(request.getParameter("teamName")));
        task.setWorker(new Member().setId(request.getParameter("memberId")));

        Team team = teamDao.selectOne(task.getTeam().getName());
        if (team == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }

        if (task.getWorker().getId().length() > 0 && 
                !teamMemberDao.isExist(task.getTeam().getName(), task.getWorker().getId())) {
            throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
        }

        taskDao.insert(task);
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
    }
}
