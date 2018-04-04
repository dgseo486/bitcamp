package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_2 {
    static class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if (name.endsWith(".java")) 
                return true; 
            return false; 
        }
    }
    
    public static void main(String[] args) {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        
        String[] names = dir.list(javaFilter);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
