package bitcamp.java106.pms.controller.teammember;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/member/add")
public class TeamMemberAddController {
    
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberAddController(TeamDao teamDao, MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");

        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        Member member = memberDao.selectOne(memberId);
        if (member == null) {
            throw new Exception(memberId + " 회원은 없습니다.");
        }
        if (teamMemberDao.isExist(teamName, memberId)) {
            throw new Exception("이미 등록된 회원입니다.");
        }
        teamMemberDao.insert(teamName, memberId);
        return "redirect:../view.do?name=" + URLEncoder.encode(teamName, "UTF-8");
    }
}