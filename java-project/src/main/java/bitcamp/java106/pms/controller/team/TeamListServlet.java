package bitcamp.java106.pms.controller.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/list")
public class TeamListServlet {
    
    TeamDao teamDao;

    public TeamListServlet(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @RequestMapping
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Team> list = teamDao.selectList();
        request.setAttribute("list", list);
        return "/team/list.jsp";
    }

}