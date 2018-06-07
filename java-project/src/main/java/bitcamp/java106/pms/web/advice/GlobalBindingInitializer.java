package bitcamp.java106.pms.web.advice;

import java.beans.PropertyEditorSupport;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import bitcamp.java106.pms.web.ClassroomController;
import bitcamp.java106.pms.web.TaskController;
import bitcamp.java106.pms.web.TeamController;

@ControllerAdvice(assignableTypes= {
        TeamController.class, ClassroomController.class, TaskController.class})
public class GlobalBindingInitializer {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("GlobalBindingInitializer.initBinder()");
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(java.sql.Date.valueOf(text));
            }
        });
    }
}
