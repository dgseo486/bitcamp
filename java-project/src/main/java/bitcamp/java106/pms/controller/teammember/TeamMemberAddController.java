package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/member/add")
public class TeamMemberAddController implements Controller {
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberAddController(TeamDao teamDao, MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
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