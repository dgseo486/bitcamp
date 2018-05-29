package bitcamp.java106.pms.controller.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/view")
public class TeamViewServlet {

    TeamDao teamDao;

    public TeamViewServlet(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @RequestMapping
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        Team team = teamDao.selectOneWithMembers(name);
        if (team == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        request.setAttribute("team", team);
        return "/team/view.jsp";
    }
}