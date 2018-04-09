package step19.ex1;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Exam03 {
    public static void main(String[] args) {
        File packageDir = new File("C:\\bitcamp\\java-basic\\src\\step19\\ex1");
        
        ApplicationContext appContext = new ApplicationContext(packageDir);
        List<File> files = appContext.getFiles();
        for(File f : files) {
            if(f.isDirectory()) {
                System.out.printf("d %s\n", f.getName());
            } else {
                System.out.printf("- %s\n", f.getName());
            }
        }
    }
}
