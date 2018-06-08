package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;

@Controller
@RequestMapping("/team")
public class TeamController {

    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    public TeamController(TeamDao teamDao, TeamMemberDao teamMemberDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    public String add(Team team) throws Exception {
        teamDao.insert(team);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("name") String name) throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("teamName", name);
        
        teamMemberDao.delete(params);
        
        taskDao.deleteByTeam(name);
        
        int count = teamDao.delete(name);
        if (count == 0) {
            throw new Exception ("해당 팀이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public void list(
            @MatrixVariable(defaultValue="1") int pageNo, 
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) throws Exception {
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        List<Team> list = teamDao.selectList(params);
        map.put("list", list);
    }
    
    @RequestMapping("update")
    public String update(Team team) throws Exception {
        
        int count = teamDao.update(team);
        if (count == 0) {
            throw new Exception("<p>해당 팀이 존재하지 않습니다.</p>");
        }
        return "redirect:list";
    }
    
    @RequestMapping("{name}")
    public String view(@PathVariable String name, Map<String,Object> map) throws Exception {
        Team team = teamDao.selectOneWithMembers(name);
        if (team == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        map.put("team", team);
        return "team/view";
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
