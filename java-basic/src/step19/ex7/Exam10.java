package step19.ex7;

public class Exam10 {
    int value;
    
    public Exam10() {
        this.value = 200;
    }
    
    public void print() {
        System.out.printf("value=%d\n", this.value);
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationContext8 appContext = new ApplicationContext8("step19.ex7");
        Exam10 obj = (Exam10) appContext.getBean("step19.ex7.Exam10");
        obj.print();
    }
}
