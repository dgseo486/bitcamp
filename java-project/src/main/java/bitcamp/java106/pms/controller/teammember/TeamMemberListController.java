package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;
import java.util.Iterator;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/member/list")
public class TeamMemberListController implements Controller {
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberListController(
            TeamDao teamDao, 
            TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        Team team = teamDao.get(teamName);
        if (team == null) {
            out.printf("%s 팀은 존재하지 않습니다.\n", teamName);
            return;
        }

        out.print("회원들: ");
        
        Iterator<String> iterator = teamMemberDao.getMembers(teamName);
        if (iterator != null) {
            while (iterator.hasNext()) {
                out.printf("%s, ", iterator.next());
            }
        }
        out.println();
    }
}