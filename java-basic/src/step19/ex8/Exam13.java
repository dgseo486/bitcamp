package step19.ex8;

public class Exam13 {
    
    public Exam13() {
        System.out.println("===> Exam13()");
    }
    
    public static void main(String[] args) throws Exception {
       UltraEngine engine = new UltraEngine();
       
       Car car = new Car();
       car.move();
       System.out.println("--------------------------");
       
       Car2 car2 = new Car2(engine);
       car2.move();
    }
}
