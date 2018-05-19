package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    
    BoardDao boardDao;

    @Override
    public void init() throws ServletException {
        boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>게시물 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시물 목록</h1>");
        try {
            List<Board> list = boardDao.selectList();
            
            out.println("<p><a href='form.html'>새 글</a></p>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>번호</th><th>제목</th><th>등록일</th>");
            out.println("</tr>");
            for (Board board : list) {
                out.println("<tr>");
                out.printf("    <td>%d</td><td><a href='view?no=%d'>%s</a></td><td>%s</td>\n", 
                        board.getNo(), board.getNo(), board.getTitle(), board.getCreatedDate());
                out.println("</tr>");
            }
            out.println("</table>");
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 목록조회 실패");
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }

}