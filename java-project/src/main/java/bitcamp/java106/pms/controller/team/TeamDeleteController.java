package bitcamp.java106.pms.controller.team;

import java.io.PrintWriter;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/delete")
public class TeamDeleteController implements Controller {
    TeamDao teamDao;
    
    public TeamDeleteController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        
        try {
            int count = teamDao.delete(name);

            if (count == 0) {
                out.println("해당 이름의 팀이 없습니다.");
                return;
            } else {
                teamDao.delete(name);
                out.println("삭제하였습니다.");
            }
        } catch (Exception e) {
            out.println("삭제 실패!");
            e.printStackTrace(out);
        }
        
        
    }
    
}