package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class TeamMemberDao {
    
    DataSource dataSource;
    
    public TeamMemberDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public int insert(String teamName, String memberId) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con
                        .prepareStatement("insert into pms_team_member(tnm, mid) values(?, ?)");) {

            stmt.setString(1, teamName);
            stmt.setString(2, memberId);
            return stmt.executeUpdate();
        }
    }
    
    public int delete(String teamName, String memberId) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from pms_team_member where tnm=? and mid=?");) {

            stmt.setString(1, teamName);
            stmt.setString(2, memberId);
            return stmt.executeUpdate();
        }
    }
    
    public List<String> selectList(String teamName) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("select mid from pms_team_member where tnm=?");) {

            stmt.setString(1, teamName);
            try (ResultSet rs = stmt.executeQuery();) {
                ArrayList<String> arr = new ArrayList<>();
                while (rs.next()) {
                    Task task = new Task();
                    arr.add(rs.getString("mid"));
                }
                return arr;
            }
        }
    }
    
    public boolean isExist(String teamName, String memberId) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("select mid from pms_team_member where tnm=? and mid=?");) {

            stmt.setString(1, teamName);
            stmt.setString(2, memberId);
            try (ResultSet rs = stmt.executeQuery();) {
                if(rs.next()) {
                    return true;
                }
                return false;
            }
        }
    }
    
}
