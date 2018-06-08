package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Team;

public interface TeamDao {
    int delete(String name);
    List<Team> selectList(Map<String,Object> map);
    int insert(Team team);
    int update(Team team);
    Team selectOne(String name);
    Team selectOneWithMembers(String name);
}
