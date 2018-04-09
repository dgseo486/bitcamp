package step19.ex1;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Exam04 {
    public static void main(String[] args) throws Exception {
        File packageDir = new File("C:\\bitcamp\\java-basic\\src\\step19");
        
        ApplicationContext2 appContext = new ApplicationContext2(packageDir);
        List<File> files = appContext.getFiles();
        for(File f : files) {
            System.out.println(f.getCanonicalPath());
        }
    }
}
