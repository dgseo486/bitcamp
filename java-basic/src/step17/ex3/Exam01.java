package step17.ex3;

public class Exam01 {
    
    int value;
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public static void main(String[] args) {
        Exam01 obj = new Exam01();
        obj.setValue(100);
        
        System.out.println(obj.getValue());
    }
}
