package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[100];
        Member[] members = new Member[100];
        int teamCount = 0;
        int memberCount = 0;

        boolean flag = true;
        while (flag) {
            System.out.print("명령> ");
            String cmd = keyScan.nextLine();
            StringTokenizer str = new StringTokenizer(cmd, " ");
            String[] temp = new String[2];
            int j=0;
            while(str.hasMoreTokens()){
                temp[j] = str.nextToken();
                j++;
            }
            if (temp[0].equals("quit")) {
                System.out.println("안녕히가세요!");
                flag = false;
            } else if (temp[0].equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
            } else if (temp[0].equals("team/add")) {
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
                teamCount++;
                System.out.println();
            } else if (temp[0].equals("team/list")) {
                for (int i = 0; i < teamCount; i++) {
                    System.out.printf("%s, %s명, %s ~ %s\n", teams[i].teamName, teams[i].maxQty, teams[i].startDate,
                            teams[i].endDate);
                }
                System.out.println();
            } else if (temp[0].equals("team/view")) {
                if (temp[1] == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                } else {
                    boolean teamCheck = true;
                    for (int i = 0; i < teamCount; i++) {
                        if (temp[1].equals(teams[i].teamName)) {
                            System.out.println("팀명: " + teams[i].teamName);
                            System.out.println("설명: " + teams[i].teamDescription);
                            System.out.println("인원: " + teams[i].maxQty);
                            System.out.println("기간: " + teams[i].startDate +  
                                                    " ~ " + teams[i].endDate);
                            teamCheck = false;
                        }
                    }
                    if (teamCheck) {
                        System.out.println("해당 이름의 팀이 없습니다.");
                    }
                }
                System.out.println();
            } else if (temp[0].equals("member/add")) {
                members[memberCount] = new Member();
                System.out.print("아이디? ");
                members[memberCount].memID = keyScan.nextLine();
                System.out.print("이메일? ");
                members[memberCount].memEM = keyScan.nextLine();
                System.out.print("암호? ");
                members[memberCount].memPW = keyScan.nextLine();
                memberCount++;
                System.out.println();
            } else if (temp[0].equals("member/list")) {
                for (int i = 0; i < memberCount; i++) {
                    System.out.printf("%s, %s, %s\n", members[i].memID, members[i].memEM, members[i].memPW);
                }
                System.out.println();
            } else if (temp[0].equals("member/view")) {
                if(temp[1] == null){
                    System.out.println("아이디를 입력하시기 바랍니다.");
                }else{
                    boolean memCheck = true;
                    for (int i = 0; i < memberCount; i++) {
                        if (temp[1].equals(members[i].memID)) {
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
                System.out.println();
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
                System.out.println();
            }
        }
        keyScan.close();
    }
}