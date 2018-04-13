package step22.ex1;

import java.io.FileInputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("temp/test1.data");
        byte[] buf = new byte[100];
        int count = in.read(buf);
        in.close();
        System.out.printf("%d\n", count);
        for(int i = 0; i < count; i++) {
            System.out.printf("%x ", buf[i]);
        }
        System.out.println();
    }
}
