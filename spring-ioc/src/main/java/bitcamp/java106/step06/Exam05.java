package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam05 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("bitcamp/java106/step06/application-context-05.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }
}
