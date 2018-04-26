package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class TeamDao {
    
    DataSource dataSource;
    
    public TeamDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public int delete(String name) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from pms_team where name=?");){
            
            stmt.setString(1, name);
            return stmt.executeUpdate();
        }
    }
    
    public List<Team> selectList() throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("select name, dscrt, max_qty, sdt, edt from pms_team");
                ResultSet rs = stmt.executeQuery();) {

            ArrayList<Team> arr = new ArrayList<>();
            while (rs.next()) {
                Team team = new Team();
                team.setName(rs.getString("name"));
                team.setDescription(rs.getString("dscrt"));
                team.setMaxQty(rs.getInt("max_qty"));
                team.setStartDate(rs.getDate("sdt"));
                team.setEndDate(rs.getDate("edt"));
                arr.add(team);
            }
            return arr;
        }
    }
    
    public int insert(Team team) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement(
                                "insert into pms_team(name, dscrt, max_qty, sdt, edt) values(?, ?, ?, ?, ?)");){
            
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getDescription());
            stmt.setInt(3, team.getMaxQty());
            stmt.setDate(4, team.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(5, team.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            
            return stmt.executeUpdate();
        }
    }
    
    public int update(Team team) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement(
                                "update pms_team set name=?, dscrt=?, max_qty=?, sdt=?, edt=? where name=?");){
            
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getDescription());
            stmt.setInt(3, team.getMaxQty());
            stmt.setDate(4, team.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(5, team.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(6, team.getName());
            return stmt.executeUpdate();
        }
    }
    
    public Team selectOne(String name) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("select name, dscrt, max_qty, sdt, edt from pms_team where name=?");) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null;
                }
                Team team = new Team();
                team.setName(name);
                team.setDescription(rs.getString("dscrt"));
                team.setMaxQty(rs.getInt("max_qty"));
                team.setStartDate(rs.getDate("sdt"));
                team.setEndDate(rs.getDate("edt"));
                return team;
            }
        }
    }
}
