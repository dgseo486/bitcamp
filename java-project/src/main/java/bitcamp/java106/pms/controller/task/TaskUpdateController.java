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

@Component("/task/update")
public class TaskUpdateController {
    
    TaskDao taskDao;
    
    public TaskUpdateController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao teamMemberDao) {
        this.taskDao = taskDao;
    }
    
    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String teamName = request.getParameter("teamName");
        Task task = new Task().setNo(Integer.parseInt(request.getParameter("no")))
                .setTitle(request.getParameter("title")).setStartDate(Date.valueOf(request.getParameter("startDate")))
                .setEndDate(Date.valueOf(request.getParameter("endDate")))
                .setState(Integer.parseInt(request.getParameter("state")))
                .setTeam(new Team().setName(request.getParameter("teamName")))
                .setWorker(new Member().setId(request.getParameter("memberId")));

        int count = taskDao.update(task);
        if (count == 0) {
            throw new Exception("해당 작업이 없습니다.");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
    }
}
