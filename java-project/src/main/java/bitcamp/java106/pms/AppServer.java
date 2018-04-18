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
    
    HTTPServer httpServer;
    ApplicationContainer applicationContainer;
    
    public AppServer(int port) throws Exception {
        applicationContainer = new DefaultApplicationContainer();
        httpServer = new HTTPServer(port, applicationContainer);
    }
    
    void service() throws Exception {
        httpServer.execute();
    }
    
    void processRequest(Socket socket) {
        PrintWriter out = null;
        Scanner in = null;
        
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
            
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
    
    /*void onQuit() {
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
        
    }*/
    
    public static void main(String[] args) throws Exception {
        AppServer appServer = new AppServer(8888);
        appServer.service();
    }
}