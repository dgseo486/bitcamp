// Worker 인터페이스를 이행하는 클래스 - 줄여서 Worker 구현체라 부른다.
package step14.ex1;

public class WhiteWorker implements Worker {
    public void execute() {
        System.out.println("사무직 노동자가 일을 합니다.");
    }
}
