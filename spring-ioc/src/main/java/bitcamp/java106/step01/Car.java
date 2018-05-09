package bitcamp.java106.step01;

public class Car {
    String model;
    String maker;
    int cc;
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + "]";
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
