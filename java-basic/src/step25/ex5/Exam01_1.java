package step25.ex5;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("step25/ex5/mybatis-config.xml");
        
        SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = Factory.openSession();
        
        System.out.println("mybatis 준비 완료!");
        
        sqlSession.close();
        
    }
}
