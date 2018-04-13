package step22.ex7;

import java.io.OutputStream;

public class DataOutputStream {
    
    OutputStream out;
    
    public DataOutputStream(OutputStream out) throws Exception {
        this.out = out;
    }
    
    public void writeUTF(String str) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        out.write(bytes.length);
        out.write(bytes);
    }
    
    public void writeInt(int value) throws Exception {
        out.write((value >> 24));
        out.write((value >> 16));
        out.write((value >> 8));
        out.write(value);
    }
    
    public void writeLong(long value) throws Exception {
        out.write((int)(value >> 56));
        out.write((int)(value >> 48));
        out.write((int)(value >> 40));
        out.write((int)(value >> 32));
        out.write((int)(value >> 24));
        out.write((int)(value >> 16));
        out.write((int)(value >> 8));
        out.write((int)value);
    }
    
    public void writeBoolean(Boolean value) throws Exception {
        if(value) {
            out.write(1);
        } else {
            out.write(0);
        }
    }
    
    public void close() throws Exception {
        out.close();
    }
    
}
