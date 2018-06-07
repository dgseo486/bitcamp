package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Controller
@RequestMapping("/team/{teamName}/task")
public class TaskController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;

    public TaskController(TeamDao teamDao, TaskDao taskDao, TeamMemberDao  teamMemberDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping("add")
    public String add(
            Task task, @PathVariable String teamName, @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        Team team = teamDao.selectOne(task.getTeam().getName());
        if (team == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", task.getTeam().getName());
        params.put("memberId", task.getWorker().getId());
        
        if (task.getWorker().getId().length() > 0 && !teamMemberDao.isExist(params)) {
            throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
        }
        
        taskDao.insert(task);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no, @PathVariable String teamName) throws Exception {
        int count = taskDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form(@PathVariable String teamName, Map<String,Object> map) throws Exception {
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        map.put("members", members);
        return "task/form";
    }
    
    @RequestMapping("list")
    public String list(@PathVariable String teamName, Map<String,Object> map) throws Exception {
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Task> list = taskDao.selectList(team.getName());
        map.put("list", list);
        return "task/list";
    }
    
    @RequestMapping("update")
    public String update(Task task, @PathVariable String teamName, @RequestParam("memberId") String memberId) throws Exception {
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        int count = taskDao.update(task);
        if (count == 0) {
            throw new Exception("<p>해당 작업이 없습니다.</p>");
        }
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(
            @PathVariable String teamName, 
            @PathVariable int no, 
            Map<String,Object> map) throws Exception {
        Task task = taskDao.selectOne(no);
        if (task == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        
        List<Member> members = teamMemberDao.selectListWithEmail(task.getTeam().getName());
        
        map.put("task", task);
        map.put("members", members);
        return "task/view";
    }
    
    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(java.sql.Date.valueOf(text));
            }
        });
    }*/
}
