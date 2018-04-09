package step19.ex2;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Exam05 {
    public static void main(String[] args) throws Exception {
        //File packageDir = new File("C:\\bitcamp\\java-basic\\src\\step19");
        ApplicationContext3 appContext = new ApplicationContext3("step19.ex1");
        List<File> files = appContext.getFiles();
        for(File f : files) {
            System.out.println(f.getCanonicalPath());
        }
    }
}
