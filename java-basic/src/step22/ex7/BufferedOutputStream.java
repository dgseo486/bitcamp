package step22.ex7;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream {

    OutputStream out;
    
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(OutputStream out) throws Exception {
        this.out = out;
    }
    
    public void write(int b) throws IOException {
        if(cursor == buf.length) {
            out.write(buf);
            cursor = 0;
        }
        buf[cursor++] = (byte)b;
    }
    
    public void close() throws IOException {
        this.flush();
        out.close();
    }
    
    public void flush() throws IOException {
        if(cursor > 0) {
            out.write(buf, 0, cursor);
            cursor = 0;
        }
    }
}
