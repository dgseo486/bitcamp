package step19.ex8;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationContext9 {
    
    private HashMap<String, Object> objPool = new HashMap<>();
    
    public ApplicationContext9(String packageName) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        File dir = new File(classLoader.getResource(packageName.replace(".", "/")).getPath());
        if(!dir.isDirectory()) {
            return;
        }
        
        findAndInstanciateClasses(dir, packageName);
    }
    
    private void findAndInstanciateClasses(File dir, String packageName) throws Exception {
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
                findAndInstanciateClasses(f, packageName + "." + f.getName());
                continue;
            }
            String classname = f.getName();
            Class clazz = Class.forName(packageName + "." + classname.substring(0, classname.length() - 6));
            
            if(objPool.get(clazz.getName()) != null) {
                continue;
            }
            
            Object obj = createObject(clazz);
            if(obj != null) {
                this.objPool.put(clazz.getName(), obj);
            }
        }
    }
    
    private Object createObject(Class clazz) throws Exception {
        try {
            clazz.getConstructor();
            return clazz.newInstance();
        } catch (Exception e) {
            Constructor[] constructors = clazz.getConstructors();
            for(Constructor constructor : constructors) {
                Object obj = callConstructor(constructor);
                if(obj != null) {
                    return obj;
                }
            }
            return null;
        }
    }
    
    private Object callConstructor(Constructor constructor) throws Exception {
        if(containsDefaultType(constructor)) {
            return null;
        }
        
        Class[] paramTypes = constructor.getParameterTypes();
        
        ArrayList<Object> paramValues = new ArrayList<>();
        for(Class paramType : paramTypes) {
            paramValues.add(findObject(paramType));
        }
        
        return constructor.newInstance(paramValues.toArray());
    }
    
    private Object findObject(Class clazz) throws Exception {
        Object obj = objPool.get(clazz.getName());
        if (obj != null) {
            return obj;
        }
        
        obj = clazz.newInstance();
        objPool.put(clazz.getName(), obj);
        return clazz.newInstance();
    }
    
    private boolean containsDefaultType(Constructor constructor) {
        Class[] defaultTypes = {
                byte.class, short.class, int.class, long.class, 
                float.class, double.class, boolean.class, char.class, 
                Byte.class, Short.class, Integer.class, Long.class, 
                Float.class, Double.class, Boolean.class, Character.class, 
                String.class
        };
        
        Class[] paramTypes = constructor.getParameterTypes();
        
        for(Class paramType : paramTypes) {
            for(Class defaultType : defaultTypes) {
                if(paramType == defaultType) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Object getBean(String name){
        return objPool.get(name);
    }
    
}
