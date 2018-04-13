package step22.ex4;

import java.io.FileInputStream;

public class DataInputStream extends FileInputStream {
    
    public DataInputStream(String filename) throws Exception {
        super(filename);
    }
    
    public String readUTF() throws Exception {
        byte[] buf = new byte[100];
        int size = this.read();
        read(buf, 0, size);
        return new String(buf, 0, size, "UTF-8");
    }
    
    public int readInt() throws Exception {
        int value = 0;
        value = value + (this.read() << 24);
        value = value + (this.read() << 16);
        value = value + (this.read() << 8);
        value = value + this.read();
        return value;
    }
    
    public long readLong() throws Exception {
        long value = 0;
        value = value + (long)(this.read() << 56);
        value = value + (long)(this.read() << 48);
        value = value + (long)(this.read() << 40);
        value = value + (long)(this.read() << 32);
        value = value + (long)(this.read() << 24);
        value = value + (long)(this.read() << 16);
        value = value + (long)(this.read() << 8);
        value = value + (long)this.read();
        return value;
    }
    
    public Boolean readBoolean() throws Exception {
        if(this.read() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
