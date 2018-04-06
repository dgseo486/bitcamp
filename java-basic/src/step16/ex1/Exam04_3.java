package step16.ex1;

import java.io.File;

public class Exam04_3 {
    public static void main(String[] args) throws Exception {
        File file = new File("temp/a/test.txt");
        
        //File dir = new File(file.getParent());
        File dir = file.getParentFile();
        
        if(dir.mkdirs()) {
            System.out.println("디렉토리 생성 성공");
        } else {
            System.out.println("디렉토리 생성 실패");
        }
        
        if(file.createNewFile()) {
            System.out.println("파일 생성 성공");
        } else {
            System.out.println("파일 생성 실패");
        }
    }
}
