package step19.ex1;

import java.io.File;

public class Exam01 {
    
    public static void main(String[] args) {
        
        File packageDir = new File("C:\\bitcamp\\java-basic\\src\\step19\\ex1");
        
        File[] files = packageDir.listFiles();
        for(File f : files) {
            if(f.isDirectory()) {
                System.out.printf("d %s\n", f.getName());
            } else {
                System.out.printf("- %s\n", f.getName());
            }
        }
    }
}
