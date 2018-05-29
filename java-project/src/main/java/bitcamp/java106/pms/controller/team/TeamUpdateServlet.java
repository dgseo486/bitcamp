package bitcamp.java106.pms.controller.team;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/update")
public class TeamUpdateServlet {
    
    TeamDao teamDao;
    
    public TeamUpdateServlet(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Team team = new Team();
        team.setName(request.getParameter("name"));
        team.setDescription(request.getParameter("description"));
        team.setMaxQty(Integer.parseInt(request.getParameter("maxQty")));
        team.setStartDate(Date.valueOf(request.getParameter("startDate")));
        team.setEndDate(Date.valueOf(request.getParameter("endDate")));
        int count = teamDao.update(team);
        if (count == 0) {
            throw new Exception("해당 이름의 팀이 없습니다.");
        }
        return "redirect:list.do";
    }
}