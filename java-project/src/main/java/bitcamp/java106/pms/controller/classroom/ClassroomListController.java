package bitcamp.java106.pms.controller.classroom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/classroom/list")
public class ClassroomListController {

    ClassroomDao classroomDao;

    public ClassroomListController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @RequestMapping
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Classroom> list = classroomDao.selectList();
        request.setAttribute("list", list);
        return "/classroom/list.jsp";
    }

}