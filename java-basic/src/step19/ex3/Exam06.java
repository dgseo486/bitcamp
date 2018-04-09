package step19.ex3;

import java.io.File;
import java.util.List;

public class Exam06 {
    public static void main(String[] args) throws Exception {
        ApplicationContext4 appContext = new ApplicationContext4("step19.ex1");
        List<File> files = appContext.getFiles();
        for(File f : files) {
            System.out.println(f.getCanonicalPath());
        }
    }
}
