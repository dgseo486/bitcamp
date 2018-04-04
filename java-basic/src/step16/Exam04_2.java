package step16;

import java.io.File;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        File file = new File("temp2/a/test.txt");
        if(file.createNewFile()) {
            System.out.println("파일 생성 성공");
        } else {
            System.out.println("파일 생성 실패");
        }
    }
}
