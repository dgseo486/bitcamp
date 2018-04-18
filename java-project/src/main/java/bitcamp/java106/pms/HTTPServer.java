package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    int port;
    ApplicationContainer applicationContainer;
    
    public HTTPServer(int port, ApplicationContainer applicationContainer) {
        this.port = port;
        this.applicationContainer = applicationContainer;
    }
    
    public  void execute() throws Exception {
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("서버 실행 했음!");
        
        while(true) {
            Socket socket = serverSocket.accept();
            processRequest(socket);
        }
    }
    
    private void processRequest(Socket socket) {
        PrintWriter out = null;
        Scanner in = null;
        
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
            
            boolean firstLine = true;
            String requestURI = null;
            
            while(true) {
                String line = in.nextLine();
                if(line.equals("")) {
                    break;
                }
                
                if(!firstLine) {
                    continue;
                }
                
                requestURI = line.split(" ")[1];
                firstLine = false;
            }
            
            String result = applicationContainer.execute(requestURI);
            
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain;charset=UTF-8");
            out.println();
            out.println(result);
            
        } catch (Exception e) {
            out.println("서버 오류!");
            e.printStackTrace(out);
            out.println();
        } finally {
            out.close();
            in.close();
            try{socket.close();} catch (Exception e) {}
        }
    }
}
