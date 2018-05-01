package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/delete")
public class ClassroomDeleteController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomDeleteController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            int count = classroomDao.delete(no);
            
            if (count == 0) {
                out.println("유효하지 않은 강의 번호입니다.");
            } else {
                out.println("삭제하였습니다.");
            }
        } catch (Exception e) {
            out.println("삭제 실패!");
            e.printStackTrace(out);
        }
    }

}
