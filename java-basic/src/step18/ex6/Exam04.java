package step18.ex6;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Exam04 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = ClassLoader.getSystemResource("step18");
        
        List<File> files = findClasses(new File(url.getPath()));
        
        for(File f : files) {
            System.out.println(f.getCanonicalPath());
        }
    }
    
    static List<File> findClasses(File dir) throws Exception {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if(file.isDirectory() || 
                        (file.getName().endsWith(".class") && !file.getName().contains("$"))) {
                    return true;
                }
                return false;
            }
        });
        
        ArrayList<File> list = new ArrayList<>();
        for(File f : files) {
            if(f.isDirectory()) {
                list.addAll(findClasses(f));
            } else {
                list.add(f);
            }
        }
        return list;
    }
}
