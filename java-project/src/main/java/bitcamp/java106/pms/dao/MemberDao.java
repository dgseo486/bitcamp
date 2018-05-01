package bitcamp.java106.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public MemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(String id) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.delete("bitcamp.java106.pms.dao.MemberDao.delete", id);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Member> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            return sqlSession.selectList("bitcamp.java106.pms.dao.MemberDao.selectList");
        }
    }
    
    public int insert(Member member) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.insert("bitcamp.java106.pms.dao.MemberDao.insert", member);
            sqlSession.commit();
            return count;
        }
    }
    
    public int update(Member member) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.insert("bitcamp.java106.pms.dao.MemberDao.update", member);
            sqlSession.commit();
            return count;
        }
    }
    
    public Member selectOne(String id) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            return sqlSession.selectOne("bitcamp.java106.pms.dao.MemberDao.selectOne", id);
        }
    }
}
