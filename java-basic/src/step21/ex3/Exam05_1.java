package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam05_1 {
    static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
        if(i < 0) {
            return;
        } else if(i == 0) {
            throw new Exception();
        } else if(i == 1) {
            throw new RuntimeException();
        } else if(i == 2) {
            throw new SQLException();
        } else {
            throw new IOException();
        }
    }
    
    public static void main(String[] args) {
        try {
            m(3);
            System.out.println("try");
        } catch (RuntimeException | SQLException | IOException e) {
            System.out.println("catch 1");
        } catch (Exception e) {
            System.out.println("catch 2");
        } finally {
            System.out.println("finally");
        }
    }
}
