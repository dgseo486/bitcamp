package bitcamp.java106.pms.web;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

@Controller
@RequestMapping("/team/member")
public class TeamMemberController {
    
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberController(TeamDao teamDao, 
            MemberDao memberDao,
            TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping("/add")
    public String add(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId,
            Map<String,Object> map) throws Exception {
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        Member member = memberDao.selectOne(memberId);
        if (member == null) {
            map.put("message", "해당 회원이 없습니다!");
            return "/team/member/fail.jsp";
        }
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", teamName);
        params.put("memberId", memberId);
        
        if (teamMemberDao.isExist(params)) {
            map.put("message", "이미 등록된 회원입니다.");
            return "/team/member/fail.jsp";
        }
        teamMemberDao.insert(params);
        return "redirect:../view.do?name=" + 
                URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/delete")
    public String delete(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId,
            Map<String,Object> map) throws Exception {
         
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", teamName);
        params.put("memberId", memberId);
        
        int count = teamMemberDao.delete(params);
        if (count == 0) {
            map.put("message", "해당 회원이 없습니다!");
            return "/team/member/fail.jsp";
        }
        return "redirect:../view.do?name=" + 
                URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("/list")
    public String list(
            @RequestParam("name") String teamName,
            Map<String,Object> map) throws Exception {
       
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        map.put("members", members);
        return "/team/member/list.jsp";
    }
}
