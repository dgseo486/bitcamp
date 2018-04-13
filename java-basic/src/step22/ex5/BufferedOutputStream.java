package step22.ex5;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(String filename) throws Exception {
        super(filename);
    }
    
    @Override
    public void write(int b) throws IOException {
        if(cursor == buf.length) {
            this.write(buf);
            cursor = 0;
        }
        buf[cursor++] = (byte)b;
    }
    
    @Override
    public void close() throws IOException {
        this.flush();
        super.close();
    }
    
    @Override
    public void flush() throws IOException {
        if(cursor > 0) {
            this.write(buf, 0, cursor);
            cursor = 0;
        }
    }
}
