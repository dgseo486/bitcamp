package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

public class BoardController {
    
    public static Scanner keyScan;

    static Board[] boards = new Board[1000];
    static int boardIndex = 0;

    public static void service (String menu, String option) {
        if (menu.equals("board/add")) {
            onBoardAdd();
        } else if (menu.equals("board/list")) {
            onBoardList();
        } else if (menu.equals("board/view")) {
            onBoardView(option);
        } else if (menu.equals("board/update")) {
            onBoardUpdate(option);
        } else if (menu.equals("board/delete")) {
            onBoardDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    static int getBoardIndex (String index) {
        for (int i = 0; i < boardIndex; i++) {
            if (boards[i] == null) continue;
            if (index.equals(boards[i].index)) {
                return i;
            }
        }
        return -1;
    }

    static void onBoardAdd() {
        System.out.println("[게시글 등록]");
        Board board = new Board();

        board.index = String.valueOf(boardIndex);

        System.out.print("제목? ");
        board.subject = keyScan.nextLine();
        
        System.out.print("내용? ");
        board.content = keyScan.nextLine();
        
        System.out.print("등록일? ");
        board.date = keyScan.nextLine();

        boards[boardIndex++] = board;
    }

    static void onBoardList() {
        System.out.println("[게시글 목록]");
        for (int i = 0; i < boardIndex; i++) {
            if(boards[i] == null) continue;
            System.out.printf("%s, %s, %s\n",
                boards[i].index, boards[i].subject, boards[i].date);
        }
    }

    static void onBoardView(String index) {
        System.out.println("[게시글 조회]");
        if (index == null) {
            System.out.println("게시글 번호를 입력하시기 바랍니다.");
            return;
        }

        int i = getBoardIndex(index);

        if (i == -1) {
            System.out.println("해당 게시글이 없습니다.");
        } else {
            Board board = boards[i];
            System.out.printf("제목: %s\n", board.subject);
            System.out.printf("내용: %s\n", board.content);
            System.out.printf("등록일: %s\n", board.date);
        }
    }

    static void onBoardUpdate(String index) {
        System.out.println("[게시글 변경]");
        if (index == null) {
            System.out.println("게시글 번호를 입력하시기 바랍니다.");
            return;
        }

        int i = getBoardIndex(index);
        
        if (i == -1) {
            System.out.println("해당 게시글이 없습니다.");
        } else {
            Board board = boards[i];
            Board updateBoard = new Board();

            System.out.printf("제목(%s)? ", board.subject);
            updateBoard.subject = keyScan.nextLine();
            
            System.out.printf("내용(%s)? ", board.content);
            updateBoard.content = keyScan.nextLine();
            
            updateBoard.index = board.index;
            updateBoard.date = board.date;
            
            boards[i] = updateBoard;
            System.out.println("변경하였습니다.");
        }
    }

    static void onBoardDelete(String index) {
        System.out.println("[게시글 삭제]");
        if (index == null) {
            System.out.println("게시글 번호를 입력하시기 바랍니다.");
            return;
        }
        
        int i = getBoardIndex(index);
        
        if (i == -1) {
            System.out.println("해당 게시글이 없습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")){
                boards[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
}