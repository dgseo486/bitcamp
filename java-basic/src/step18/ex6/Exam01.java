package step18.ex6;

import java.net.URL;

public class Exam01 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("step18/ex6");
        System.out.println(url.getPath());
        System.out.println(url.getFile());
    }
}
