package step19.ex2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext3 {
    
    private ArrayList<File> list = new ArrayList<>();
    
    public ApplicationContext3(String packageName) {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        File dir = new File(url.getPath());
        if(!dir.isDirectory()) {
            return;
        }
        findFiles(dir);
    }
    
    private void findFiles(File dir) {
        File[] files = dir.listFiles();
        for(File f : files) {
            if(f.isDirectory()) {
                findFiles(f);
            } else {
                this.list.add(f);
            }
        }
    }
    
    public List<File> getFiles(){
        return this.list;
    }
}
