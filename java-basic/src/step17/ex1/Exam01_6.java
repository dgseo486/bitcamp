//클래스의 종류 : anonymous class
package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_6 {
    
    public static void main(String[] args) throws Exception {
        
        File dir = new File(".");
        
        //anonymous class
        String[] names = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if(name.endsWith(".java")) {
                    return true;
                }
                return false;
            }
        });
        
        for(String name : names) {
            System.out.println(name);
        }
    }
}
