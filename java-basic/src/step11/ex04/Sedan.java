package step11.ex04;

public class Sedan extends step11.ex01.Car {
    boolean sunroof;
    boolean auto;
    
    public Sedan(String model, String maker, int capacity, boolean sunroof, boolean auto) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
        this.sunroof = sunroof;
        this.auto = auto;
    }
}
