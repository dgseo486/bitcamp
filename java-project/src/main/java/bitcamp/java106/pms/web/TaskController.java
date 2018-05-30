package bitcamp.java106.pms.web;

import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task")
public class TaskController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    public TaskController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping("/add")
    public String add(Task task, @RequestParam("teamName") String teamName, @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        Team team = teamDao.selectOne(task.getTeam().getName());
        if (team == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }

        if (task.getWorker().getId().length() > 0 && 
                !teamMemberDao.isExist(task.getTeam().getName(), task.getWorker().getId())) {
            throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
        }

        taskDao.insert(task);
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("teamName") String teamName, @RequestParam("no") int no) throws Exception {
        int count = taskDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/form")
    public String form(@RequestParam("teamName") String teamName, Map<String,Object> map) throws Exception {
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        map.put("members", members);
        return "/task/form.jsp";
    }
    
    @RequestMapping("/list")
    public String list(@RequestParam("teamName") String teamName, Map<String,Object> map) throws Exception {
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Task> list = taskDao.selectList(team.getName());
        map.put("list", list);
        return  "/task/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Task task, @RequestParam("teamName") String teamName, @RequestParam("memberId") String memberId) throws Exception {
        int count = taskDao.update(task);
        if (count == 0) {
            throw new Exception("해당 작업이 없습니다.");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/view")
    public String view(@RequestParam("no") int no, Map<String,Object> map) throws Exception {
        Task task = taskDao.selectOne(no);
        if (task == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(task.getTeam().getName());
        map.put("task", task);
        map.put("members", members);
        return "/task/view.jsp";
    }
}
