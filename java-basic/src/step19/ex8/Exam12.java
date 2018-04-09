package step19.ex8;

public class Exam12 {
    
    public Exam12() {
        System.out.println("===> Exam12()");
    }
    
    public static void main(String[] args) throws Exception {
       Engine engine = new Engine();
       Car2 car = new Car2(engine);
       car.move();
    }
}
