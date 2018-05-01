package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.sql.Date;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/update")
public class TaskUpdateController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TaskUpdateController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao teamMemberDao, MemberDao memberDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
        this.memberDao = memberDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            Task task = new Task()
                    .setNo(Integer.parseInt(request.getParameter("no")))
                    .setTitle(request.getParameter("title"))
                    .setStartDate(Date.valueOf(request.getParameter("startDate")))
                    .setEndDate(Date.valueOf(request.getParameter("endDate")))
                    .setTeam(new Team().setName(request.getParameter("teamName")))
                    .setWorker(new Member().setId(request.getParameter("memberId")));
            
            int count = taskDao.update(task);
            if(count == 0) {
                out.println("해당 작업이 없습니다.");
            } else {
                out.println("변경하였습니다.");
            }
        } catch (Exception e) {
            out.println("변경 실패!");
            e.printStackTrace(out);
        }
    }

}
