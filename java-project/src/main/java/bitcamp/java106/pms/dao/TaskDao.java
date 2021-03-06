package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Task;

public interface TaskDao {
    int delete(int no);
    int deleteByTeam(String teamName);
    List<Task> selectList(Map<String, Object> map);
    int insert(Task task);
    int update(Task task);
    Task selectOne(int no);
    int updateState(Map<String,Object> params);
}
