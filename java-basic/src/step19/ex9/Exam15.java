package step19.ex9;

public class Exam15 {
    public Exam15() {
        System.out.println("===> Exam15()");
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationContext10 iocContainer = new ApplicationContext10("step19.ex9");
        Car car = (Car) iocContainer.getBean("car");
        car.move();
    }
}
