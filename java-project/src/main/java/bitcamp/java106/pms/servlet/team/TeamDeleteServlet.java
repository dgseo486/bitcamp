package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/delete")
public class TeamDeleteServlet extends HttpServlet {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        try {
            teamMemberDao.delete(name);
            taskDao.deleteByTeam(name);
            int count = teamDao.delete(name);
    
            if (count == 0) {
                throw new Exception("해당 팀이 없습니다.");
            }
            response.sendRedirect("list");
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 삭제 실패");
            요청배달자.forward(request, response);
        }
    }
    
}