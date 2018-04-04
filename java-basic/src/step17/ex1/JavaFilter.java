package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class JavaFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        if (name.endsWith(".java"))
            return true;
        return false;
    }

}
