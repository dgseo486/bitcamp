package bitcamp.java106.step10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new AnnotationConfigApplicationContext("bitcamp.java106.step10");
        
        BeanUtils.printBeanNames(iocContainer);
    }
}
