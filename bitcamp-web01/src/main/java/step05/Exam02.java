package step05;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step05/exam02_test.html
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart) {
            out.println("멀티파트 형식이 아닙니다.");
            return;
        }
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        Map<String,String> paramMap = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item : items) {
                if(item.isFormField()) {
                    out.printf("%s=%s\n", item.getFieldName(), item.getString("UTF-8"));
                } else {
                    out.printf("%s=%s\n", item.getFieldName(), item.getName());
                    ServletContext appEnvInfo = request.getServletContext();
                    String savedPath = appEnvInfo.getRealPath("/");
                    out.println(savedPath);
                    item.write(new File(savedPath + "/" + item.getName()));
                }
            }
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }
        
    }
}
