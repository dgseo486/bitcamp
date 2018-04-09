package bitcamp.java106.pms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java106.pms.Context.ApplicationContext;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class App {
    
    static ApplicationContext iocContainer;
    
    static Scanner keyScan = new Scanner(System.in);
    static String option = null;

    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add"); 
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("게시글 등록 명령 : board/add");
        System.out.println("게시글 조회 명령 : board/list");
        System.out.println("게시글 상세조회 명령 : board/view");
        System.out.println("게시글 변경 명령 : board/update");
        System.out.println("게시글 삭제 명령 : board/delete");
        System.out.println("작업 등록 명령 : task/add");
        System.out.println("작업 조회 명령 : task/list");
        System.out.println("작업 상세조회 명령 : task/view");
        System.out.println("작업 변경 명령 : task/update");
        System.out.println("작업 삭제 명령 : task/delete");
        System.out.println("작업 진행 상태 조회 명령 : task/state");
        System.out.println("종료 : quit");
    }

    public static void main(String[] args) throws Exception {
        
        HashMap<String, Object> defaultBeans = new HashMap<>();
        defaultBeans.put("java.util.Scanner", keyScan);
        
        iocContainer = new ApplicationContext("bitcamp.java106.pms", defaultBeans);
        
        //테스트용 데이터셋
        prepareMemberData();
        prepareTeamData();
        
        Console.keyScan = keyScan;

        while (true) {
            String[] input = Console.prompt();
            
            String menu = input[0];

            if (input.length == 2) {
                option = input[1]; 
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else {
                int slashIndex = menu.lastIndexOf("/");
                String controllerKey = (slashIndex < 0) ? menu : menu.substring(0, slashIndex);
                
                Controller controller = (Controller) iocContainer.getBean(controllerKey);
                
                if (controller != null) {
                    controller.service(menu, option);
                } else {
                    System.out.println("명령어가 올바르지 않습니다.");
                }
            } 
        }
    }
    
    //테스트용 데이터셋
    static void prepareMemberData() {
        MemberDao memberDao = (MemberDao) iocContainer.getBean("bitcamp.java106.pms.dao.MemberDao");
        
        Member member = new Member();
        member.setId("aaa");
        member.setEmail("aaa@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("bbb");
        member.setEmail("bbb@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ccc");
        member.setEmail("ccc@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ddd");
        member.setEmail("ddd@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("eee");
        member.setEmail("eee@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
    }
    
    static void prepareTeamData() {
        TeamDao teamDao = (TeamDao) iocContainer.getBean("bitcamp.java106.pms.dao.TeamDao");
        TeamMemberDao teamMemberDao = (TeamMemberDao) iocContainer.getBean("bitcamp.java106.pms.dao.teamMemberDao");
        
        Team team = new Team();
        team.setName("t1");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-1-1"));
        team.setEndDate(Date.valueOf("2018-5-30"));
        teamDao.insert(team);
        teamMemberDao.addMember("t1", "aaa");
        teamMemberDao.addMember("t1", "bbb");
        teamMemberDao.addMember("t1", "ccc");
        
        team = new Team();
        team.setName("t2");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-2-1"));
        team.setEndDate(Date.valueOf("2018-6-30"));
        teamDao.insert(team);
        teamMemberDao.addMember("t2", "ccc");
        teamMemberDao.addMember("t2", "ddd");
        teamMemberDao.addMember("t2", "eee");
        
    }
}