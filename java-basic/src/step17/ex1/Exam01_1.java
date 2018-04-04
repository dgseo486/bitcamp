package step17.ex1;

import java.io.File;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        
        String[] names = dir.list(javaFilter);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
