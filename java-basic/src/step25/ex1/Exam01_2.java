package step25.ex1;

import java.sql.DriverManager;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        
    }
}
