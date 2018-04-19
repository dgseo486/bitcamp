package bitcamp.java106.pms;

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
    
    public static void main(String[] args) throws Exception {
        AppServer appServer = new AppServer(8888);
        appServer.service();
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
}