package bitcamp.java106.step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        iocContainer = 
                new FileSystemXmlApplicationContext(
                        "file:\\bitcamp\\spring-ioc\\src\\main\\java\\bitcamp\\java106\\step01\\application-context.xml");
        
        Car car = (Car) iocContainer.getBean("c1");
        System.out.println(car);
        
        car = (Car) iocContainer.getBean("c2");
    }
}
