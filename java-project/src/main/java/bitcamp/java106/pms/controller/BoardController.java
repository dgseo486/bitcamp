package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController implements Controller {
    
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
        board.setTitle(this.keyScan.nextLine());
        
        System.out.print("내용? ");
        board.setContent(this.keyScan.nextLine());
        
        System.out.print("등록일? ");
        board.setCreatedDate(Date.valueOf(this.keyScan.nextLine()));

        boardDao.insert(board);
    }

    void onBoardList() {
        System.out.println("[게시글 목록]");
        Board[] list = boardDao.list();
        for(Board board : list) {
            System.out.printf("%d, %s, %s\n", 
                    board.getNo(), board.getTitle(), board.getCreatedDate());
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
            System.out.printf("제목: %s\n", board.getTitle());
            System.out.printf("내용: %s\n", board.getContent());
            System.out.printf("등록일: %s\n", board.getCreatedDate());
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
            updateBoard.setNo(board.getNo());
            System.out.printf("제목(%s)? ", board.getTitle());
            updateBoard.setTitle(this.keyScan.nextLine());
            System.out.printf("내용(%s)? ", board.getContent());
            updateBoard.setContent(this.keyScan.nextLine());
            updateBoard.setCreatedDate(board.getCreatedDate());
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
        
        int i = Integer.parseInt(index);
        Board board = boardDao.get(i);
        
        if (board == null) {
            System.out.println("유효하지 않는 게시물 번호입니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")){
                boardDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }
}