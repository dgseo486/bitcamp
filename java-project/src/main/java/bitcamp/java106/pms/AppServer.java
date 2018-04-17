package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import bitcamp.java106.pms.Context.ApplicationContext;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public class AppServer {
    
    ApplicationContext iocContainer;
    
    AppServer() throws Exception {
        init();
    }
    
    void init() throws Exception {
        iocContainer = new ApplicationContext("bitcamp.java106.pms");
    }
    
    void onQuit() {
        System.out.println("안녕히 가세요!");
        
        BoardDao boardDao = (BoardDao)iocContainer.getBean(BoardDao.class);
        ClassroomDao classroomDao = (ClassroomDao)iocContainer.getBean(ClassroomDao.class);
        MemberDao memberDao = (MemberDao)iocContainer.getBean(MemberDao.class);
        TaskDao taskDao = (TaskDao)iocContainer.getBean(TaskDao.class);
        TeamDao teamDao = (TeamDao)iocContainer.getBean(TeamDao.class);
        TeamMemberDao teamMemberDao = (TeamMemberDao)iocContainer.getBean(TeamMemberDao.class);
        
        try {boardDao.save();}
        catch (Exception e) {System.out.println("게시물 데이터 저장 중 오류 발생");}
        
        try {classroomDao.save();}
        catch (Exception e) {System.out.println("수업 데이터 저장 중 오류 발생");}
        
        try {memberDao.save();}
        catch (Exception e) {System.out.println("회원 데이터 저장 중 오류 발생");}
        
        try {taskDao.save();}
        catch (Exception e) {System.out.println("작업 데이터 저장 중 오류 발생");}
        
        try {teamDao.save();}
        catch (Exception e) {System.out.println("팀 데이터 저장 중 오류 발생");}
        
        try {teamMemberDao.save();}
        catch (Exception e) {System.out.println("팀멤버 데이터 저장 중 오류 발생");}
        
    }
    
    void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }
    
    void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("서버 실행 했음!");
        
        while(true) {
            Socket socket = serverSocket.accept();
            processRequest(socket);
        }
    }
    
    void processRequest(Socket socket) {
        PrintWriter out = null;
        Scanner in = null;
        
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
            
            ServerRequest request = new ServerRequest(in.nextLine());
            ServerResponse response = new ServerResponse(out);
            
            String path = request.getServerPath();
            Controller controller = (Controller) iocContainer.getBean(path);
            
            if (controller != null) {
                controller.service(request, response);
            } else {
                out.println("해당 명령을 처리할 수 없습니다.");
            }
            out.println();
            
        } catch (Exception e) {
            out.println("서버 오류!");
            e.printStackTrace(out);
            out.println();
        } finally {
            out.close();
            in.close();
            try{socket.close();} catch (Exception e) {}
        }
    }
    
    public static void main(String[] args) throws Exception {
        AppServer appServer = new AppServer();
        appServer.service();
    }
}