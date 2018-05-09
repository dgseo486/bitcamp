package bitcamp.java106.step05;

import java.util.List;

public class Car2 {
    String model;
    String maker;
    int cc;
    Engine engine;
    List<Tire> tires;
    
    @Override
    public String toString() {
        return "Car2 [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + "]";
    }
    public List<Tire> getTires() {
        return tires;
    }
    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        System.out.println("setEngine() 호출됨!");
        this.engine = engine;
    }
    public String getModel() {
        return model;
    }
    public String getMaker() {
        return maker;
    }
    public int getCc() {
        return cc;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
}
