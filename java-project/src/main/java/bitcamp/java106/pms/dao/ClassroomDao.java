package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomDao {
    int delete(int no);
    List<Classroom> selectList(Map<String, Object> params);
    Classroom selectOne(int no);
    int insert(Classroom classroom);
    int update(Classroom classroom);
}
