package bitcamp.java106.pms.controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/view")
public class TaskViewController {
    
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    public TaskViewController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao teamMemberDao) {
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        Task task = taskDao.selectOne(no);
        if (task == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(task.getTeam().getName());
        request.setAttribute("task", task);
        request.setAttribute("members", members);
        return "/task/view.jsp";
    }
}
