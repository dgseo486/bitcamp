// 인스턴스와 인스턴스 변수, 인스턴스 메서드
package step08;

public class Exam03_2 {
    static class Calculator {
        
        int result;
        
        // 이름에 인스턴스가 붙었다고 해서 인스턴스 메서드는 Heap에 만들어지는 것이 아니다.
        // 클래스의 모든 코드는 Method Area 영역에 로딩 된다.
        public void plus(int value) {
            this.result = result + value;
        }
        
        public void minus(int value) {
            this.result = result - value;
        }
    }
    
    public static void main(String[] args) {
        // Heap에 인스턴스 변수가 생성된다.
        // 인스턴스 메서드가 생성되는 것이 아니다.
        Calculator c1 = new Calculator();
        Calculator c2 = new Calculator();
        
        // 인스턴스 메서드는 메서드는 모두 Method Area 영역에 올라간다.
        // 그리고 인스턴스를 가지고 그 메서드를 호출하는 것이다.
        
        c1.plus(123);
        
        c2.minus(30);
    }
}
