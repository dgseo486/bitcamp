package step25.ex1;

import java.sql.DriverManager;

public class Exam01_4 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Driver driver = DriverManager.getDriver("jdbc:mysql:");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        //등록되지 않은 드라이버
        //driver = DriverManager.getDriver("jdbc:oracle");
    }
}
