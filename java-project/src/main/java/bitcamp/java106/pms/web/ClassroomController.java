package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    
    ClassroomDao classroomDao;
    
    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    public String add(Classroom classroom) throws Exception {
        classroomDao.insert(classroom);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int count = classroomDao.delete(no);
        if (count == 0) {
            throw new Exception("<p>해당 강의가 없습니다.</p>");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public void list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) throws Exception {
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        List<Classroom> list = classroomDao.selectList(params);
        map.put("list", list);
    }
    
    @RequestMapping("update")
    public String update(Classroom classroom) throws Exception {
        int count = classroomDao.update(classroom);
        if (count == 0) {
            throw new Exception("해당 강의가 존재하지 않습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Map<String,Object> map) throws Exception {
        Classroom classroom = classroomDao.selectOne(no);
        if (classroom == null) {
            throw new Exception("유효하지 않은 강의입니다.");
        }
        map.put("classroom", classroom);
        return "classroom/view";
    }
    
    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(java.sql.Date.valueOf(text));
            }
        });
    }*/
}
