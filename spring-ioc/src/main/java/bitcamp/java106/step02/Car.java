package bitcamp.java106.step02;

public class Car {
    String model;
    String maker;
    int cc;
    
    public Car() {
        System.out.println("Car() 생성자 호출됨!");
    }
    
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
        System.out.println("setModel() 생성자 호출됨!");
        this.model = model;
    }
    public void setMaker(String maker) {
        System.out.println("setMaker() 생성자 호출됨!");
        this.maker = maker;
    }
    public void setCc(int cc) {
        System.out.println("setCc() 생성자 호출됨!");
        this.cc = cc;
    }
}
