package step11.ex03;

public class Car2 {
    String model;
    String maker;
    int capacity;
    boolean sunroof;
    boolean auto;
    
    public Car2() {}
    
    public Car2(String model, String maker, int capacity) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
    
    public Car2(String model, String maker, int capacity, boolean sunroof, boolean auto) {
        this(model, maker, capacity);
        this.sunroof = sunroof;
        this.auto = auto;
    }
}
