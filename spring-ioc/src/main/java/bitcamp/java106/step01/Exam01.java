package bitcamp.java106.step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step01/application-context.xml");
        
        Car car = (Car) iocContainer.getBean("c1");
        System.out.println(car);
        
        car = (Car) iocContainer.getBean("c2");
    }
}
