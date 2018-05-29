package bitcamp.java106.pms.controller.teammember;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/member/delete")
public class TeamMemberDeleteController {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberDeleteController(TeamDao teamDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");

        int count = teamMemberDao.delete(teamName, memberId);
        if (count == 0) {
            throw new Exception("<p>해당 팀원이 존재하지 않습니다.</p>");
        }
        return "redirect:../view.do?name=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
}