package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/update")
public class TeamUpdateServlet extends HttpServlet {
    
    TeamDao teamDao;
    
    @Override
    public void init() throws ServletException {
        this.teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        try {
            Team team = new Team();
            team.setName(request.getParameter("name"));
            team.setDescription(request.getParameter("description"));
            team.setMaxQty(Integer.parseInt(request.getParameter("mamQty")));
            team.setStartDate(Date.valueOf(request.getParameter("startDate")));
            team.setEndDate(Date.valueOf(request.getParameter("endDate")));
            
            int count = teamDao.update(team);
            if (count == 0) {
                throw new Exception("해당 이름의 팀이 없습니다.");
            }
            response.sendRedirect("list");
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 변경 실패");
            요청배달자.forward(request, response);
        }
    }
}