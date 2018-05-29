package bitcamp.java106.pms.controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/form")
public class TaskFormController {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    public TaskFormController(TeamDao teamDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping
    public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String teamName = request.getParameter("teamName");
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        request.setAttribute("members", members);
        return "/task/form.jsp";
    }
}
