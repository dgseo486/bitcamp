package bitcamp.java106.step05;

import java.util.Arrays;

public class Car {
    String model;
    String maker;
    int cc;
    Engine engine;
    Tire[] tires;
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + ", tires="
                + Arrays.toString(tires) + "]";
    }
    public Tire[] getTires() {
        return tires;
    }
    public void setTires(Tire[] tires) {
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
