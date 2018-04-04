package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_3 {
    class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if(name.endsWith(".java")) {
                return true;
            }
            return false;
        }
    }
    
    public void test() {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        
        String[] names = dir.list(javaFilter);
        for(String name : names) {
            System.out.println(name);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Exam01_3 obj = new Exam01_3();
        obj.test();
    }
}
