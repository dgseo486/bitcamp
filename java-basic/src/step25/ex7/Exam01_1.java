package step25.ex7;

import java.sql.DriverManager;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/java106db", "java106", "1111");
        
        java.sql.PreparedStatement stmt = con.prepareStatement("insert into ex_board(bno,titl,cont,rdt) values(?,?,?,now())");
        
        stmt.setInt(1, 101);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력성공");
        
        stmt.setInt(1, 102);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력성공");
        
        stmt.setInt(1, 101);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력성공");
        
        stmt.close();
        con.close();
        System.out.println("입력완료");
    }
}
