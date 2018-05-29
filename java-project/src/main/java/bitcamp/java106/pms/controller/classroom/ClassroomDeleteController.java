package bitcamp.java106.pms.controller.classroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/classroom/delete")
public class ClassroomDeleteController {
    
    ClassroomDao classroomDao;

    public ClassroomDeleteController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        int count = classroomDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 강의가 없습니다.");
        }
        return "redirect:list.do";
    }
    
}
