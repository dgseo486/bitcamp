// Worker 구현체 사용
package step14.ex1;

public class Exam01 {
    public static void main(String[] args) {
        Worker w1 = new BlueWorker();
        
        //Worker w2 = new String(); // 컴파일 오류
        Worker w2 = new WhiteWorker();
        Worker w3 = new JubuWorker();
        
        w1.execute();
        w2.execute();
        w3.execute();
        
        // caller : Exam01
        // callee : BlueWorker, WhiteWorker, JubuWorker
    }
}
