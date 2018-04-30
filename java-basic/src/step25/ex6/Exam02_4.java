package step25.ex6;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam02_4 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("step25/ex6/mybatis-config07.xml");
        
        SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = Factory.openSession();
        
        Board board = new Board();
        board.setTitle("제목이래요!");
        board.setContent("내용이래요!");
        
        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.println("--------------------------------------");
        
        int count = sqlSession.insert("BoardMapper.insertBoard", board);
        System.out.println(count);
        
        sqlSession.commit();
        
        sqlSession.close();
    }
}
