package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController {
    
    Scanner keyScan;
    
    BoardDao boardDao = new BoardDao();
    
    public BoardController(Scanner scanner) {
        this.keyScan = scanner;
    }

    public void service (String menu, String option) {
        if (menu.equals("board/add")) {
            this.onBoardAdd();
        } else if (menu.equals("board/list")) {
            this.onBoardList();
        } else if (menu.equals("board/view")) {
            this.onBoardView(option);
        } else if (menu.equals("board/update")) {
            this.onBoardUpdate(option);
        } else if (menu.equals("board/delete")) {
            this.onBoardDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onBoardAdd() {
        System.out.println("[게시글 입력]");
        Board board = new Board();

        System.out.print("제목? ");
        board.title = this.keyScan.nextLine();
        
        System.out.print("내용? ");
        board.content = this.keyScan.nextLine();
        
        System.out.print("등록일? ");
        board.createdDate = Date.valueOf(this.keyScan.nextLine());

        boardDao.insert(board);
    }

    void onBoardList() {
        System.out.println("[게시글 목록]");
        Board[] list = boardDao.list();
        for(int i = 0; i < list.length; i++) {
            if(list[i] == null) {
                continue;
            }
            System.out.printf("%d, %s, %s\n", 
                    i, list[i].title, list[i].createdDate);
        }
    }

    void onBoardView(String index) {
        System.out.println("[게시글 조회]");
        if (index == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(index));
        
        if (board == null) {
            System.out.println("유효하지 않는 게시물 번호입니다.");
        } else {
            System.out.printf("제목: %s\n", board.title);
            System.out.printf("내용: %s\n", board.content);
            System.out.printf("등록일: %s\n", board.createdDate);
        }
    }

    void onBoardUpdate(String index) {
        System.out.println("[게시글 변경]");
        if (index == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(index));
        
        if (board == null) {
            System.out.println("유효하지 않는 게시물 번호입니다.");
        } else {
            Board updateBoard = new Board();
            System.out.printf("제목(%s)? ", board.title);
            updateBoard.title = this.keyScan.nextLine();
            System.out.printf("내용(%s)? ", board.content);
            updateBoard.content = this.keyScan.nextLine();
            updateBoard.createdDate = board.createdDate;
            updateBoard.no = board.no;
            boardDao.update(updateBoard);
            System.out.println("변경하였습니다.");
        }
    }

    void onBoardDelete(String index) {
        System.out.println("[게시글 삭제]");
        if (index == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(index));
        
        if (board == null) {
            System.out.println("유효하지 않는 게시물 번호입니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")){
                boardDao.delete(board.no);
                System.out.println("삭제하였습니다.");
            }
        }
    }
}