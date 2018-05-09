package bitcamp.java106.step05;

import java.util.Properties;

public class Car4 {
    String model;
    String maker;
    int cc;
    Properties options;
    
    @Override
    public String toString() {
        return "Car4 [model=" + model + ", maker=" + maker + ", cc=" + cc + ", options=" + options + "]";
    }
    public Properties getOptions() {
        return options;
    }
    public void setOptions(Properties options) {
        this.options = options;
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
