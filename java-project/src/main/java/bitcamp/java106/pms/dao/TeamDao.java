package bitcamp.java106.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Team;

@Component
public class TeamDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public TeamDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(String name) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            int count = sqlSession.delete("bitcamp.java106.pms.dao.TeamDao.delete", name);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Team> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();){
            return sqlSession.selectList("bitcamp.java106.pms.dao.TeamDao.selectList");
        }
    }
    
    public int insert(Team team) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.insert("bitcamp.java106.pms.dao.TeamDao.insert", team);
            sqlSession.commit();
            return count;
        }
    }
    
    public int update(Team team) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.update("bitcamp.java106.pms.dao.TeamDao.update", team);
            sqlSession.commit();
            return count;
        }
    }
    
    public Team selectOne(String name) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            return sqlSession.selectOne("bitcamp.java106.pms.dao.TeamDao.selectOne", name);
        }
    }
}
