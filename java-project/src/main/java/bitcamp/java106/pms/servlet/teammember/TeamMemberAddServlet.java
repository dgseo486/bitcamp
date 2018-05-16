package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/teammember/add")
public class TeamMemberAddServlet extends HttpServlet {
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        memberDao = InitServlet.getApplicationContext().getBean(MemberDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");

        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                out.printf("%s 팀은 존재하지 않습니다.\n", teamName);
                return;
            }
            Member member = memberDao.selectOne(memberId);
            if (member == null) {
                out.printf("%s 회원은 없습니다.\n", memberId);
                return;
            }
            if (teamMemberDao.isExist(teamName, memberId)) {
                out.println("이미 등록된 회원입니다.");
                return;
            }
            teamMemberDao.insert(teamName, memberId);
            out.println("팀에 회원을 추가하였습니다.");
            
        } catch (Exception e) {
            out.println("등록 실패!");
            e.printStackTrace(out);
        }
    }
}