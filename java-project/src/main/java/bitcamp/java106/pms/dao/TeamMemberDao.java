package bitcamp.java106.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public TeamMemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(String teamName, String memberId) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            paramMap.put("memberId", memberId);
            
            int count = sqlSession.insert("bitcamp.java106.pms.dao.TeamMemberDao.insert", paramMap);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(String teamName, String memberId) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            paramMap.put("memberId", memberId);
            
            int count = sqlSession.delete("bitcamp.java106.pms.dao.TeamMemberDao.delete", paramMap);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<String> selectList(String teamName) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            return sqlSession.selectList("bitcamp.java106.pms.dao.TeamMemberDao.selectList", teamName);
        }
    }
    
    public boolean isExist(String teamName, String memberId) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("teamName", teamName);
            paramMap.put("memberId", memberId);
            
            int count = sqlSession.selectOne("bitcamp.java106.pms.dao.TeamMemberDao.isExist", paramMap);
            if(count > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
