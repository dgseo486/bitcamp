package bitcamp.java106.pms.jdbc;

import java.sql.Connection;

public interface DataSource {
    Connection getConnection() throws Exception;
    void returnConnection(Connection con);
}
