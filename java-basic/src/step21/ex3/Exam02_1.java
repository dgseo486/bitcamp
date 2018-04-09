package step21.ex3;

public class Exam02_1 {
    static void m() throws Throwable {
        throw new Throwable();
    }
    
    static void m2() throws Error {
        throw new Error();
    }
    
    static void m3() {
        throw new Error();
    }
    
    static void m4() throws Exception {
        throw new Exception();
    }
    
    static void m5() throws Exception {
        throw new String();
    }
    
    public static void main(String[] args) {
        
    }
}
