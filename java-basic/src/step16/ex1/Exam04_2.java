package step16.ex1;

import java.io.File;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        File file = new File("temp2/a/test.txt");
        if(file.delete()) {
            System.out.println("파일 삭제 성공");
        } else {
            System.out.println("파일 삭제 실패");
        }
    }
}
