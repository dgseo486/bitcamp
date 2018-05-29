package bitcamp.java106.pms.controller.classroom;

import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.web.RequestMapping;

@WebServlet("/classroom/update")
public class ClassroomUpdateController {
    
    ClassroomDao classroomDao;
    
    public ClassroomUpdateController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Classroom classroom = new Classroom();
        classroom.setNo(Integer.parseInt(request.getParameter("no")));
        classroom.setTitle(request.getParameter("title"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        classroom.setRoom(request.getParameter("room"));

        int count = classroomDao.update(classroom);
        if (count == 0) {
            throw new Exception("해당 강의가 존재하지 않습니다.");
        }
        return "redirect:list.do";
    }

}
