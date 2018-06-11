package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.service.TaskService;
import bitcamp.java106.pms.service.TeamService;

@Controller
@RequestMapping("/team/{teamName}/task")
public class TaskController {
    
    TaskService taskService;
    TeamService teamService;

    public TaskController(TaskService taskService, TeamService teamService) {
        this.taskService = taskService;
        this.teamService = teamService;
    }
    
    @RequestMapping("add")
    public String add(
            Task task, @PathVariable String teamName, @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        if (teamService.get(teamName) == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }
        
        taskService.add(task);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no, @PathVariable String teamName) throws Exception {
        if (taskService.delete(no) == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form(@PathVariable String teamName, Map<String,Object> map) throws Exception {
        if (teamService.get(teamName) == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        
        map.put("teamName", teamName);
        map.put("members", teamService.getMembersWithEmail(teamName));
        
        return "task/form";
    }
    
    @RequestMapping("list{page}")
    public String list(
            @PathVariable String teamName, 
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) throws Exception {
        
        if (teamService.get(teamName) == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        
        map.put("teamName", teamName);
        map.put("list", taskService.list(teamName, pageNo, pageSize));
        
        return "task/list";
    }
    
    @RequestMapping("update")
    public String update(Task task, @PathVariable String teamName, @RequestParam("memberId") String memberId) throws Exception {
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        if (taskService.update(task) == 0) {
            throw new Exception("<p>해당 작업이 없습니다.</p>");
        }
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(
            @PathVariable String teamName, 
            @PathVariable int no, 
            Map<String,Object> map) throws Exception {
        Task task = taskService.get(no);
        if (task == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        
        map.put("teamName", teamName);
        map.put("members", teamService.getMembersWithEmail(teamName));
        map.put("task", task);
        
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
