package step19.ex4;

import java.util.List;

public class Exam07 {
    public static void main(String[] args) throws Exception {
        ApplicationContext5 appContext = new ApplicationContext5("step19.ex1");
        List<String> classnames = appContext.getClassname();
        for(String name : classnames) {
            System.out.println(name);
        }
    }
}
