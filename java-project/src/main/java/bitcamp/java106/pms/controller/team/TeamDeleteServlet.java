package bitcamp.java106.pms.controller.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/delete")
public class TeamDeleteServlet {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    public TeamDeleteServlet(TeamDao teamDao, TeamMemberDao teamMemberDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }

    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        teamMemberDao.delete(name);
        taskDao.deleteByTeam(name);
        int count = teamDao.delete(name);
        if (count == 0) {
            throw new Exception("해당 팀이 없습니다.");
        }
        return "redirect:list.do";
    }
    
}