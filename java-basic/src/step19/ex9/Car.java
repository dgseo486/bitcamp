package step19.ex9;

@Component(value="car")
public class Car {
    Engine engine;
    
    public Car(Engine engine) {
        System.out.println("===> Car(Engine)");
        this.engine = engine;
    }
    
    public void move() {
        this.engine.run();
    }
}
