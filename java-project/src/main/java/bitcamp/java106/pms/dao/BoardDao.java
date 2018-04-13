package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao extends AbstractDao<Board> {
    
    public BoardDao() throws Exception {
        this.load();
    }
    
    public void load() throws Exception {
        try (ObjectInputStream in = 
                new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/board.data")));) {
            while(true) {
                try {
                    this.insert((Board) in.readObject());
                } catch(Exception e) {
                    break;
                }
            }
        }
    }
    
    public void save() throws Exception {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/board.data")));) {
            Iterator<Board> boards = this.list();
            
            while(boards.hasNext()) {
                out.writeObject(boards.next());
            }
        }
    }
    
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
