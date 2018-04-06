package step18.ex6;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {
    
    public List<Class> classes;
    
    public ApplicationContext(String packagename) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        URL url = classLoader.getResource(packagename.replace('.', '/'));
        
        this.classes = findClasses(new File(url.getPath()), packagename);
        
    }
    
    private List<Class> findClasses(File dir, String packagename) throws Exception {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if(file.isDirectory() || 
                        (file.getName().endsWith(".class") && !file.getName().contains("$"))) {
                    return true;
                }
                return false;
            }
        });
        
        ArrayList<Class> list = new ArrayList<>();
        for(File f : files) {
            if(f.isDirectory()) {
                list.addAll(findClasses(f, packagename + "." + f.getName()));
            } else {
                String classname = packagename +"."+f.getName();
                list.add(Class.forName(
                                classname.substring(0, classname.length() - 6)));
            }
        }
        return list;
    }
}
