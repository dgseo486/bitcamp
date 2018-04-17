package bitcamp.java106.pms;

import bitcamp.java106.pms.server.ServerRequest;

public class Test {

    public static void main(String[] args) {
        String str = "/board/add?title=aaa&content=bbb";
        
        ServerRequest request = new ServerRequest(str);
        
        System.out.println(request.getServerPath());
        System.out.println(request.getParameter("title"));
        System.out.println(request.getParameter("content"));
        System.out.println(request.getParameter("age"));
    }

}
