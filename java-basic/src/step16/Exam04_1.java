package step16;

import java.io.File;

public class Exam04_1 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp2/a/test.txt");
        if(dir.createNewFile()) {
            System.out.println("파일 생성 성공");
        } else {
            System.out.println("파일 생성 실패");
        }
    }
}
