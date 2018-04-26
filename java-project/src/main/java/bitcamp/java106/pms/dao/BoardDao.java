package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class BoardDao {
    
    DataSource dataSource;
    
    public BoardDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public int delete(int no) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from pms_board where bno=?");){
            
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
    }
    
    public List<Board> selectList() throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("select bno,titl,cdt from pms_board");
                ResultSet rs = stmt.executeQuery();) {

            ArrayList<Board> arr = new ArrayList<>();
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setCreatedDate(rs.getDate("cdt"));
                arr.add(board);
            }
            return arr;
        }
    }
    
    public int insert(Board board) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("insert into pms_board(titl, cont, cdt) values(?, ?, now())");){
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            
            return stmt.executeUpdate();
        }
    }
    
    public int update(Board board) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("update pms_board set titl=?, cont=?, cdt=now() where bno=?");){
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }
    
    public Board selectOne(int no) throws Exception {
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = 
                        con.prepareStatement("select bno,titl,cont,cdt from pms_board where bno=?");) {

            stmt.setInt(1, no);

            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null;
                }
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setCreatedDate(rs.getDate("cdt"));
                return board;
            }
        }
    }
}
