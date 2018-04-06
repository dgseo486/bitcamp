package step18.ex4;

import java.lang.reflect.Constructor;

public class Exam03 {
    
    int value;
    
    public Exam03(int i) {
        this.value = i;
    }
    
    public void print() {
        System.out.printf("value=%d\n", this.value);
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Exam03.class;
        
        // Exam03 obj = (Exam03)clazz.newInstance(); // 실행 오류
        Constructor c = clazz.getConstructor(int.class);
        // 인스턴스 생성
        Exam03 obj = (Exam03) c.newInstance(200);
        obj.print();
    }
}
