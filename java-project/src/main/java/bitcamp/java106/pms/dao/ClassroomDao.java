package bitcamp.java106.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public ClassroomDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            int count = sqlSession.delete("bitcamp.java106.pms.dao.ClassroomDao.delete", no);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Classroom> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            return sqlSession.selectList("bitcamp.java106.pms.dao.ClassroomDao.selectList"); 
        }
    }
    
    public int insert(Classroom classroom) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            int count = sqlSession.insert("bitcamp.java106.pms.dao.ClassroomDao.insert", classroom);
            sqlSession.commit();
            return count;
        }
    }
    
    public int update(Classroom classroom) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            int count = sqlSession.update("bitcamp.java106.pms.dao.ClassroomDao.update", classroom);
            sqlSession.commit();
            return count;
        }
    }
    
    public Classroom selectOne(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            return sqlSession.selectOne("bitcamp.java106.pms.dao.ClassroomDao.selectOne", no); 
        }
    }
}
