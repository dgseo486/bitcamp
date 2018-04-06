package step16.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam06_2 {
    
    static class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if(name.endsWith(".java")) {
                return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) throws Exception {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        
        File[] files = dir.listFiles(javaFilter);
        
        for(File file : files) {
            System.out.printf("%s %12d %s\n", 
                    file.isDirectory() ? "d" : "-", file.length(), file.getName());
        }
    }
}
