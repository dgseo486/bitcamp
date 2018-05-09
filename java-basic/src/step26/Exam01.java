package step26;

import java.io.FileReader;
import java.util.Properties;

public class Exam01 {
    static String filename = "message";
    static String userCountry = "US";
    static String userLanguage = "en";
    static Properties label;
    
    static void init() throws Exception {
        if(System.getProperty("user.country") != null) {
            userCountry = System.getProperty("user.country");
        }
        if(System.getProperty("user.language") != null) {
            userLanguage = System.getProperty("user.language");
        }
        label = new Properties();
        label.load(new FileReader(
                String.format("%s-%s%s.properties",
                        filename, userLanguage, userCountry)));
    }
    
    public static void main(String[] args) throws Exception {
        init();
        System.out.println(label.get("welcome"));
    }

}
