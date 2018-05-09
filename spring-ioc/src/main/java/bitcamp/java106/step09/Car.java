package bitcamp.java106.step09;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Car {
    String model;
    String maker;
    int cc;
    boolean auto;
    Date createdDate;
    Engine engine;
    
    public Car(Engine engine) {
        this.engine = engine;
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", auto=" + auto + ", createdDate="
                + createdDate + ", engine=" + engine + "]";
    }

    /*public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }*/

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
