package bitcamp.java106.pms.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

import bitcamp.java106.pms.Annotation.Component;

public class DefaultDataSource implements DataSource {
    String driver;
    String jdbcUrl;
    String user;
    String password;
    
    ArrayList<Connection> conPool = new ArrayList<>();
    
    public DefaultDataSource(String propFilePath) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(propFilePath));
        this.driver = props.getProperty("jdbc.driver");
        this.jdbcUrl = props.getProperty("jdbc.url");
        this.user = props.getProperty("jdbc.username");
        this.password = props.getProperty("jdbc.password");
        
        Class.forName(driver);
    }
    
    public DefaultDataSource(String driver, String jdbcUrl, String user, String password) throws Exception {
        this.driver = driver;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        
        Class.forName(driver);
    }
    
    public Connection getConnection() throws Exception {
        if(conPool.size() == 0) {
            System.out.println("새 연결 객체를 만든다.");
            return new ConnectionProxy(this, DriverManager.getConnection(jdbcUrl, user, password));
        }
        
        Connection con = conPool.remove(0);
        if(con.isClosed() || !con.isValid(1)) {
            System.out.println("새 연결 객체를 만든다.");
            return new ConnectionProxy(this, DriverManager.getConnection(jdbcUrl, user, password));
        }
        
        System.out.println("기존 연결 객체를 사용한다.");
        return con;
    }
    
    public void returnConnection(Connection con) {
        conPool.add(con);
    }
}
