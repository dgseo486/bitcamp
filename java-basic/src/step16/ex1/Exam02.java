package step16.ex1;

import java.io.File;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        File f = new File(".");
        
        File file1 = new File("/src/step16/Exam01.java");
        System.out.printf("파일명: %s\n", file1.getName());
        System.out.printf("파일크기: %d\n", file1.length());
        System.out.printf("경로: %s\n", file1.getPath());
        System.out.printf("절대경로: %s\n", file1.getAbsolutePath());
        System.out.printf("계산된 절대경로: %s\n", file1.getCanonicalPath());
        
        System.out.printf("총크기: %d\n", file1.getTotalSpace());
        System.out.printf("남은크기: %d\n", file1.getFreeSpace());
        System.out.printf("가용크기: %d\n", file1.getUsableSpace());
        
        System.out.printf("디렉토리여부: %b\n", file1.isDirectory());
        System.out.printf("파일여부: %b\n", file1.isFile());
        System.out.printf("감춤폴더: %b\n", file1.isHidden());
        System.out.printf("존재여부: %b\n", file1.exists());
        System.out.printf("실행가능여부: %b\n", file1.canExecute());
        
        System.out.println("------------------------------------------");
        
        File file2 = new File("src/step16/ok.java");
        System.out.printf("폴더명: %s\n", file2.getName());
        System.out.printf("파일크기: %d\n", file2.length());
        System.out.printf("경로: %s\n", file2.getPath());
        System.out.printf("절대경로: %s\n", file2.getAbsolutePath());
        System.out.printf("계산된 절대경로: %s\n", file2.getCanonicalPath());
        
        System.out.printf("총크기: %d\n", file2.getTotalSpace());
        System.out.printf("남은크기: %d\n", file2.getFreeSpace());
        System.out.printf("가용크기: %d\n", file2.getUsableSpace());
        
        System.out.printf("디렉토리여부: %b\n", file2.isDirectory());
        System.out.printf("파일여부: %b\n", file2.isFile());
        System.out.printf("감춤폴더: %b\n", file2.isHidden());
        System.out.printf("존재여부: %b\n", file2.exists());
        System.out.printf("실행가능여부: %b\n", file2.canExecute());
    }
}
