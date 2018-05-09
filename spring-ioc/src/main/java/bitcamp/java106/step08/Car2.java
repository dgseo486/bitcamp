package bitcamp.java106.step08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Car2 {
    String model;
    String maker;
    int cc;
    boolean auto;
    Date createdDate;
    Engine engine;
    
    public Car2() {
        System.out.println("Car2()");
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", auto=" + auto + ", createdDate="
                + createdDate + ", engine=" + engine + "]";
    }

    public Engine getEngine() {
        return engine;
    }
    
    @Autowired
    public void setEngine(Engine engine) {
        System.out.println("Car.setEngine()");
        this.engine = engine;
    }

    public boolean isAuto() {
        return auto;
    }
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
