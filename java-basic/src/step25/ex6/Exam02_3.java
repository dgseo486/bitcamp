package step25.ex6;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam02_3 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("step25/ex6/mybatis-config06.xml");
        
        SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = Factory.openSession();
        
        Board board = new Board();
        board.setTitle("제목이래요!");
        board.setContent("내용이래요!");
        
        int count = sqlSession.insert("BoardMapper.insertBoard", board);
        System.out.println(count);
        
        sqlSession.commit();
        
        sqlSession.close();
    }
}
