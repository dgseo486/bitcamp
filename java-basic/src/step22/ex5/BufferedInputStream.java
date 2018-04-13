package step22.ex5;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
    byte[] buf = new byte[8196];
    int size;
    int cursor;
    
    public BufferedInputStream(String filename) throws Exception {
        super(filename);
    }
    
    @Override
    public int read() throws IOException {
        if(cursor == size) {
            if((size = this.read(buf))== -1) {
                return -1;
            }
            cursor = 0;
        }
        return 0x000000ff & buf[cursor++];
    }
}
