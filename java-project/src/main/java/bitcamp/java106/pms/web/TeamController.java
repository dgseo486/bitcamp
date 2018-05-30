package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;

@Component("/team")
public class TeamController {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    public TeamController(TeamDao teamDao, TeamMemberDao teamMemberDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping("/add")
    public String add(Team team) throws Exception {
        teamDao.insert(team);
        return "redirect:list.do";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("name") String name) throws Exception {
        teamMemberDao.delete(name);
        taskDao.deleteByTeam(name);
        int count = teamDao.delete(name);
        if (count == 0) {
            throw new Exception("해당 팀이 없습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(Map<String,Object> map) throws Exception {
        List<Team> list = teamDao.selectList();
        map.put("list", list);
        return "/team/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Team team) throws Exception {
        int count = teamDao.update(team);
        if (count == 0) {
            throw new Exception("해당 이름의 팀이 없습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/view")
    public String view(@RequestParam("name") String name, Map<String,Object> map) throws Exception {
        Team team = teamDao.selectOneWithMembers(name);
        if (team == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        map.put("team", team);
        return "/team/view.jsp";
    }
}
