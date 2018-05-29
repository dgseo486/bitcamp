package bitcamp.java106.pms.controller.task;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/delete")
public class TaskDeleteController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskDeleteController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String teamName = request.getParameter("teamName");
        int no = Integer.parseInt(request.getParameter("no"));
        int count = taskDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
}
