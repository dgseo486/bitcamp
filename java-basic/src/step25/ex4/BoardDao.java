package step25.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    DataSource dataSource;

    public BoardDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int delete(int no) throws Exception {
        try (Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from ex_board where bno=?");) {

            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
    }

    List<Board> list() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
                PreparedStatement stmt = con.prepareStatement("select bno,titl,rdt from ex_board");
                ResultSet rs = stmt.executeQuery();) {

            ArrayList<Board> arr = new ArrayList<>();
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setRegisteredDate(rs.getDate("rdt"));
                arr.add(board);
            }
            return arr;
        }
    }

    public int insert(Board board) throws Exception {
        try (Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from ex_board where bno=?");) {

            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());

            return stmt.executeUpdate();
        }
    }

    public int update(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from ex_board where bno=?");) {

            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }

    public Board view(String no) throws Exception {
        try (Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("delete from ex_board where bno=?");) {

            stmt.setString(1, no);

            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    return null;
                }
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setRegisteredDate(rs.getDate("rdt"));
                return board;
            }
        }
    }

}
