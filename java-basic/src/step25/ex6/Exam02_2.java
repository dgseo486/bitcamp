package step25.ex6;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("step25/ex6/mybatis-config05.xml");
        
        SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = Factory.openSession();
        
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("limitSQL", "limit 9, 5");
        
        List<Board> list = sqlSession.selectList("BoardMapper.selectBoard", paramMap);
        
        for(Board board : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    board.getNo(), board.getTitle(), board.getContent(), board.getRegisteredDate());
        }
        
        sqlSession.close();
    }
}
