package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam05_2 {
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
    
    static void test1() throws Exception {
        try {
            m(-1);
        } finally {
            System.out.println("정상적인 실행");
        }
    }
    
    static void test2() throws Exception {
        try {
            m(0);
        } finally {
            System.out.println("Exception 예외가 발생");
        }
    }
    
    public static void main(String[] args) {
        try { test1(); } catch (Exception e) {}
        try { test2(); } catch (Exception e) {}
    }
}
