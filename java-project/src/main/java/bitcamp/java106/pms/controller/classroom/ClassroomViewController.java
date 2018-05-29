package bitcamp.java106.pms.controller.classroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/classroom/view")
public class ClassroomViewController {
    
    ClassroomDao classroomDao;
    
    public ClassroomViewController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        Classroom classroom = classroomDao.selectOne(no);
        if (classroom == null) {
            throw new Exception("유효하지 않은 강의 번호입니다.");
        }
        request.setAttribute("classroom", classroom);
        return "/classroom/view.jsp";
    }

}
