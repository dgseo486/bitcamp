package step22.ex8;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
    
    InputStream in;
    
    byte[] buf = new byte[8196];
    int size;
    int cursor;
    
    public BufferedInputStream(InputStream in) throws Exception {
        this.in = in;
    }
    
    public int read() throws IOException {
        if(cursor == size) {
            if((size = in.read(buf))== -1) {
                return -1;
            }
            cursor = 0;
        }
        return 0x000000ff & buf[cursor++];
    }
    
    public void close() throws IOException {
        in.close();
    }
}
