package bitcamp.java106.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Task;

@Component
public class TaskDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public TaskDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.delete("bitcamp.java106.pms.dao.TaskDao.delete", no);
            sqlSession.commit();
            return count;
        }
    }

    public List<Task> selectList(String teamName) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            return sqlSession.selectList("bitcamp.java106.pms.dao.TaskDao.selectList", teamName);
        }
    }

    public int insert(Task task) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.insert("bitcamp.java106.pms.dao.TaskDao.insert", task);
            sqlSession.commit();
            return count;
        }
    }

    public int update(Task task) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            int count = sqlSession.update("bitcamp.java106.pms.dao.TaskDao.update", task);
            sqlSession.commit();
            return count;
        }
    }

    public Task selectOne(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            return sqlSession.selectOne("bitcamp.java106.pms.dao.TaskDao.selectOne", no);
        }
    }
    
    public int updateState(int no, int state) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession();) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("no", no);
            paramMap.put("state", state);
            
            int count = sqlSession.update("bitcamp.java106.pms.dao.TaskDao.delete", paramMap);
            sqlSession.commit();
            return count;
        }
    }
}
