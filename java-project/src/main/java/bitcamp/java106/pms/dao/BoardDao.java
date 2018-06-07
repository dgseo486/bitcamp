package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Board;

public interface BoardDao {
    int delete(int no) ;
    List<Board> selectList(Map<String,Object> params);
    int insert(Board board);
    int update(Board board);
    Board selectOne(int no);
}
