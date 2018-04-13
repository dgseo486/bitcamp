package step23.ex1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiver {
    
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);

        String filename = din.readUTF();
        File file = new File(filename);
        FileOutputStream out = new FileOutputStream(file);

        int b;
        while((b = in.read()) != -1) {
            out.write(b);
        }

        out.flush();
        out.close();
    }
}
