package step19.ex5;

import java.util.List;

public class Exam08 {
    public static void main(String[] args) throws Exception {
        ApplicationContext6 appContext = new ApplicationContext6("step19.ex1");
        List<Class> classes = appContext.getClasses();
        for(Class clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
}
