package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao extends AbstractDao<Board> {
    
    public int indexOf(Object key) {
        int index = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            Board board = collection.get(i);
            if (board.getNo() == index) {
                return i;
            }
        }
        return -1;
    }
}
