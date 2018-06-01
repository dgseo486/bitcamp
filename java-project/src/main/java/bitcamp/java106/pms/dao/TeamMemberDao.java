package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Member;

public interface TeamMemberDao {
    int insert(Map<String,Object> params);
    int delete(Map<String,Object> params);
    int delete(String teamName);
    List<String> selectList(String teamName);
    List<Member> selectListWithEmail(String teamName);
    boolean isExist(Map<String,Object> params);
}
