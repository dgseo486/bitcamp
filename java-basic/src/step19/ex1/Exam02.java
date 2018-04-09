package step19.ex1;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Exam02 {
    public static void main(String[] args) {
        File packageDir = new File("C:\\bitcamp\\java-basic\\src\\step19\\ex1");
        
        List<File> files = findFiles(packageDir);
        
        for(File f : files) {
            if(f.isDirectory()) {
                System.out.printf("d %s\n", f.getName());
            } else {
                System.out.printf("- %s\n", f.getName());
            }
        }
        
        
    }
    
    static List<File> findFiles(File dir) {
        LinkedList<File> list = new LinkedList<>();
        File[] files = dir.listFiles();
        for(File f : files) {
            list.add(f);
        }
        return list;
    }
}
