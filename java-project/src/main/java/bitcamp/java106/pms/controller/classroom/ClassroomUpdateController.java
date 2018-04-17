package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.util.Console;

@Component("/classroom/update")
public class ClassroomUpdateController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomUpdateController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        Classroom updateClassroom = new Classroom();
        updateClassroom.setTitle(request.getParameter("title"));
        updateClassroom.setStartDate(Date.valueOf(request.getParameter("startdate")));
        updateClassroom.setEndDate(Date.valueOf(request.getParameter("enddate")));
        updateClassroom.setRoom(request.getParameter("room"));
        
        Classroom classroom = classroomDao.get(updateClassroom.getNo());
        
        if (classroom == null) {
            out.println("유효하지 않은 수업 번호입니다.");
        } else {
            int index = classroomDao.indexOf(classroom.getNo());
            classroomDao.update(index, updateClassroom);
            out.println("변경하였습니다.");
        }
        
    }

}
