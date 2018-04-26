package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class MemberDao {
    
    DataSource dataSource;
    
    public MemberDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public int delete(String id) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from pms_member where mid=?");){
            
            stmt.setString(1, id);
            return stmt.executeUpdate();
        }
    }
    
    public List<Member> selectList() throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("select mid, email from pms_member");
                ResultSet rs = stmt.executeQuery();) {

            ArrayList<Member> arr = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                arr.add(member);
            }
            return arr;
        }
    }
    
    public int insert(Member member) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("insert into pms_member(mid, email, pwd) values(?, ?, sha2(?, 224))");){
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            
            return stmt.executeUpdate();
        }
    }
    
    public int update(Member member) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("update pms_member set mid=?, email=?, pwd=sha2(?,224) where mid=?");){
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            return stmt.executeUpdate();
        }
    }
    
    public Member selectOne(String id) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("select mid, email from pms_member where mid=?");) {

            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null;
                }
                Member member = new Member();
                member.setId(id);
                member.setEmail(rs.getString("email"));
                return member;
            }
        }
    }
}
