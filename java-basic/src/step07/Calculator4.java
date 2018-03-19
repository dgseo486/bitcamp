// 메서드 분류 - 인스턴스 메서드 사용
package step07;

public class Calculator4 {
    int result = 0;
    
    public void plus (int value) {
        this.result = this.result + value;
    }
    public void minus (int value) {
        this.result = this.result - value;
    }
    public void multiple (int value) {
        this.result = this.result * value;
    }
    public void divide (int value) {
        this.result = this.result / value;
    }
}
