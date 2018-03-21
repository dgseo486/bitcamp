// 생성자 - 생성자 호출 막기
package step08;

class X {
    // 생성자의 접근 범위를 private으로 설정하면 외부에서 접근할 수 없기 때문에
    // 결국은 생성자를 호출하지 못하는 상태로 만들 수 있다.
    private X() {
        System.out.println("X()");        
    }
}

public class Exam04_4 {
    
    public static void main(String[] args) {
        X obj1;
        obj1 = new X();
    }
}