package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/view")
public class TaskViewController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskViewController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Task task = taskDao.selectOne(no);
            if (task == null) {
                out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n", no);
                return;
            }
            
            out.printf("팀명 : %s\n", task.getTeam().getName());
            out.printf("작업번호: %d\n", no);
            out.printf("작업명: %s\n", task.getTitle());
            out.printf("시작일: %s\n", task.getStartDate());
            out.printf("종료일: %s\n", task.getEndDate());
            out.printf("작업자: %s\n", (task.getWorker() == null) ? "-" : task.getWorker().getId());
            out.printf("작업상태: %s\n", getStateLabel(task.getState()));
        } catch (Exception e) {
            out.println("상세 조회 실패!");
            e.printStackTrace(out);
        }
    }

    public static String getStateLabel(int state) {
        switch (state) {
        case Task.READY: return "작업대기";
        case Task.WORKING: return "작업중";
        case Task.COMPLETE: return "작업완료";
        default:
            return null;
        }
    }
    
}
