package step19.ex3;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext4 {
    
    private ArrayList<File> list = new ArrayList<>();
    
    public ApplicationContext4(String packageName) {
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
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if(pathname.isDirectory() || 
                        (pathname.getName().endsWith(".class") && !pathname.getName().contains("$"))) {
                    return true;
                }
                return false;
            }
        });
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
