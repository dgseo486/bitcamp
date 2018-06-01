package bitcamp.java106.step12.ex4;

import java.util.List;
import java.util.Map;

import bitcamp.java106.step12.Board;

public interface BoardDao {
    List<Board> selectList(Map<String,Object> map);
    int insert(Board board);
    int delete(int no);
}
