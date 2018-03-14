package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    static Scanner keyScan = new Scanner(System.in);

    static Team[] teams = new Team[100];
    static Member[] members = new Member[100];
    static int teamCount = 0;
    static int memberCount = 0;
    static String option = null;
    
    static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }

    static void onQuit() {
        System.out.println("안녕히가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    static void onTeamAdd() {
        System.out.println("[팀 정보 입력]");
        teams[teamCount] = new Team();
        System.out.print("팀명? ");
        teams[teamCount].teamName = keyScan.nextLine();
        System.out.print("설명? ");
        teams[teamCount].teamDescription = keyScan.nextLine();
        System.out.print("최대인원? ");
        teams[teamCount].maxQty = keyScan.nextLine();
        System.out.print("시작일? ");
        teams[teamCount].startDate = keyScan.nextLine();
        System.out.print("종료일? ");
        teams[teamCount].endDate = keyScan.nextLine();
        System.out.printf("%s, %s, %s, %s, %s\n", 
            teams[teamCount].teamName, teams[teamCount].teamDescription,
            teams[teamCount].maxQty, teams[teamCount].startDate,
            teams[teamCount].endDate);
        teamCount++;
    }

    static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamCount; i++) {
            System.out.printf("%s, %s명, %s ~ %s\n", 
                teams[i].teamName, teams[i].maxQty, teams[i].startDate,
                teams[i].endDate);
        }
    }

    static void onTeamView() {
        System.out.println("[팀 정보 조회]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return;
        } else {
            boolean teamCheck = true;
            for (int i = 0; i < teamCount; i++) {
                if (option.equals(teams[i].teamName.toLowerCase())) {
                    System.out.printf("팀명: %s\n", teams[i].teamName);
                    System.out.printf("설명: %s\n", teams[i].teamDescription);
                    System.out.printf("인원: %s\n", teams[i].maxQty);
                    System.out.printf("기간: %s ~ %s\n", 
                        teams[i].startDate, teams[i].endDate);
                    teamCheck = false;
                }
            }
            if (teamCheck) {
                System.out.println("해당 이름의 팀이 없습니다.");
            }
        }
    }

    static void onMemberAdd() {
        System.out.println("[회원 정보 입력]");
        members[memberCount] = new Member();
        System.out.print("아이디? ");
        members[memberCount].memID = keyScan.nextLine();
        System.out.print("이메일? ");
        members[memberCount].memEM = keyScan.nextLine();
        System.out.print("암호? ");
        members[memberCount].memPW = keyScan.nextLine();
        memberCount++;
    }

    static void onMemberList() {
        System.out.println("[회원 목록]");
        for (int i = 0; i < memberCount; i++) {
            System.out.printf("%s, %s, %s\n", 
            members[i].memID, members[i].memEM, members[i].memPW);
        }
    }

    static void onMemberView(){
        System.out.println("[회원 정보 조회]");
        if(option == null){
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        }else{
            boolean memCheck = true;
            for (int i = 0; i < memberCount; i++) {
                if (option.equals(members[i].memID.toLowerCase())) {
                    System.out.println("아이디: " + members[i].memID);
                    System.out.println("이메일: " + members[i].memEM);
                    System.out.println("암호: " + members[i].memPW);
                    memCheck = false;
                }
            }
            if (memCheck) {
                System.out.println("해당 아이디의 회원이 없습니다.");
            }
        }        
    }

    public static void main(String[] args) {

        while (true) {
            String[] cmd = prompt();
            String menu = cmd[0];

            if(cmd.length == 2){
                option = cmd[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();        
            } else if (menu.equals("team/add")) {
                onTeamAdd();    
            } else if (menu.equals("team/list")) {
                onTeamList();
            } else if (menu.equals("team/view")) {
                onTeamView();
            } else if (menu.equals("member/add")) {
                onMemberAdd();
            } else if (menu.equals("member/list")) {
                onMemberList();
            } else if (menu.equals("member/view")) {
                onMemberView(); 
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println();
        }
    }
}