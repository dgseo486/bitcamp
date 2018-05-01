package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
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
        
        try {
            out.print("회원들: ");
            
            List<String> list = teamMemberDao.selectList(teamName);
            for (String memberId : list) {
                out.printf("%s, ", memberId);
            }
            out.println();
            
        } catch (Exception e) {
            out.println("목록 가져오기 실패!");
            e.printStackTrace(out);
        }
    }
}