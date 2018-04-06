package step16.ex1;

import java.io.File;

public class Exam03_3 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp");
        
        if(dir.delete()) {
            System.out.println("삭제 성공");
        } else {
            // 디렉토리 안에 파일이나 다른 하위 디렉토리가 있다면 삭제 불가능
            System.out.println("삭제 실패");
        }
    }
}
