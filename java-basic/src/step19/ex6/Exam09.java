package step19.ex6;

import java.util.List;

public class Exam09 {
    public static void main(String[] args) throws Exception {
        ApplicationContext7 appContext = new ApplicationContext7("step19.ex1");
        List<Object> objects = appContext.getObjects();
        for(Object obj : objects) {
            System.out.println(obj.getClass().getName());
        }
    }
}
