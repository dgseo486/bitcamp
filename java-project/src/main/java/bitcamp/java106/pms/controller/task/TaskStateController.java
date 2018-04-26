package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/state")
public class TaskStateController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskStateController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            int state = Integer.parseInt(request.getParameter("state"));
            if (!(state == Task.READY || state == Task.WORKING || state == Task.COMPLETE)) {
                out.println("올바르지 않은 값입니다. 이전 상태를 유지합니다.");
                return;
            }
            int count = taskDao.updateState(no, state);
            if(count == 0) {
                out.println("해당 작업이 없습니다.");
            } else {
                out.printf("작업 상태를 '%s'로 변경하였습니다.\n", getStateLabel(state));
            }
        } catch (Exception e) {
            out.println("변경 실패!");
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
