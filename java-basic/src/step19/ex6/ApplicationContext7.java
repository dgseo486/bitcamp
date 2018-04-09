package step19.ex6;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext7 {
    private ArrayList<Object> list = new ArrayList<>();
    
    public ApplicationContext7(String packageName) throws Exception {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        File dir = new File(url.getPath());
        if(!dir.isDirectory()) {
            return;
        }
        findClasses(dir, packageName);
    }
    
    private void findClasses(File dir, String packageName) throws Exception {
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
                findClasses(f, packageName + "." + f.getName());
                continue;
            }
            String classname = f.getName();
            Class clazz = Class.forName(packageName + "." + classname.substring(0, classname.length() - 6));
            Object obj = createObject(clazz);
            if(obj != null) {
                this.list.add(obj);
            }

        }
    }
    
    private Object createObject(Class clazz) {
        try {
            clazz.getConstructor();
            return clazz.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Object> getObjects(){
        return this.list;
    }
}
