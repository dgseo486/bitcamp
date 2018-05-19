package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/member/delete")
public class TeamMemberDeleteServlet extends HttpServlet {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        
        
        try {
            int count = teamMemberDao.delete(teamName, memberId);
            if (count == 0) {
                throw new Exception("<p>해당 팀원이 존재하지 않습니다.</p>");
            }
            response.sendRedirect("../view?name=" + URLEncoder.encode(teamName, "UTF-8"));
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 회원 삭제 실패!");
            요청배달자.forward(request, response);
        }
    }
    
}