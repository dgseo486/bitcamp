//클래스의 종류 : anonymous class
package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_5 {
    
    public static void main(String[] args) throws Exception {
        //anonymous class
        FilenameFilter javaFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if(name.endsWith(".java")) {
                    return true;
                }
                return false;
            }
        };
        
        File dir = new File(".");
        
        String[] names = dir.list(javaFilter);
        for(String name : names) {
            System.out.println(name);
        }
    }
}
