package step25.ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam01_list {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mariadb.jdbc.Driver");
        Connection con = 
                DriverManager.getConnection("jdbc:mariadb://localhost:3306/java106db", "java106", "1111");
        PreparedStatement stmt = con.prepareStatement("select bno, titl, cont, rdt from ex_board");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            System.out.printf("%d, %s, %s\n", rs.getInt("bno"), rs.getString("titl"), rs.getDate("rdt"));
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}
