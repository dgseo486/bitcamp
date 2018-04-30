package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/member/delete")
public class TeamMemberDeleteController implements Controller {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberDeleteController(
            TeamDao teamDao, 
            TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        
        try {
            int count = teamMemberDao.delete(teamName, memberId);
            if(count == 0) {
                out.println("해당 팀원은 존재하지 않습니다.");
            } else {
                out.println("팀에서 회원을 삭제하였습니다.");
            }
        } catch (Exception e) {
            out.print("삭제 실패!");
            e.printStackTrace(out);
        }
    }
}