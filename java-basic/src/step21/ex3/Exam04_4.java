package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam04_4 {
    static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
        if(i == 0) {
            throw new Exception();
        } else if(i == 1) {
            throw new RuntimeException();
        } else if(i == 2) {
            throw new SQLException();
        } else {
            throw new IOException();
        }
    }
    
    public static void main(String[] args) {
        try {
            m(1);
        } catch (Exception e) {
            
        } catch (SQLException e) {
            
        } catch (RuntimeException e) {
            
        } catch (IOException e) {
            
        }
    }
}
