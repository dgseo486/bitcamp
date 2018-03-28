// 오버라이딩 - 문법과 의미
package step11.ex11;

public class Exam03 {

    public static void main(String[] args) {
        A3 obj1 = new A3();
        obj1.name = "홍길동";
        obj1.age = 20;
        
        obj1.print();
    }

}

//오버라이딩 : 부모로부터 상속 받은 메서드 중에서 자신의 역할에 맞지 않는 메서드가 있다면
//             자신의 역할에 맞춰 상속받은 메서드를 재정의하여 프로그래밍의 일관성을 확보하는 문법
