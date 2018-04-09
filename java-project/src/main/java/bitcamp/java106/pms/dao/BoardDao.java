package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao extends AbstractDao<Board> {
    
    public BoardDao() throws Exception {
        this.load();
    }
    
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/board.csv"));
        
        while(true) {
            try {
                String[] arr = in.nextLine().split(",");
                Board board = new Board();
                board.setNo(Integer.parseInt(arr[0]));
                board.setTitle(arr[1]);
                board.setContent(arr[2]);
                board.setCreatedDate(Date.valueOf(arr[3]));
                this.insert(board);
            } catch(Exception e) {
                break;
            }
        }
        in.close();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/board.csv"));
        
        Iterator<Board> boards = this.list();
        
        while(boards.hasNext()) {
            Board board = boards.next();
            out.printf("%d,%s,%s,%s", board.getNo(), board.getTitle(), board.getContent(), board.getCreatedDate());
        }
        out.close();
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
