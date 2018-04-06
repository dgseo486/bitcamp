package step18.ex6;

import java.util.List;

public class Exam06 {
    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new ApplicationContext("step11");
        List<Class> classes = appContext.classes;
        for(Class clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
}
