package step19.ex8;

public class Car2 {
    Engine engine;
    
    public Car2(Engine engine) {
        System.out.println("===> Car2(Engine)");
        this.engine = engine;
    }
    
    public void move() {
        engine.run();
    }
}
