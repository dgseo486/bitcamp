package step11.ex05;

public class Exam01 {

    public static void main(String[] args) {
        B obj = new B();
        obj.v2 = 200;
        obj.v1 = 100;
        System.out.printf("v2=%d, v1=%d\n", obj.v2, obj.v1);
        
        // 인스턴스 생성절차
        // 1. B 클래스가 사용한다고 선언한 클래스를 먼저 메모리에 로딩한다.
        //    즉 A 클래스를 메모리에 로딩한다.
        // 2. B 클래스를 메모리에 로딩한다.
        // 3. A 클래스에 선언된 대로 인스턴스 변수를 Heap에 만든다.
        // 4. B 클래스에 선언된 대로 인스턴스 변수를 Heap에 만든다.
        
        // 그래서 인스턴스를 생성할 때는 항상 상속 받아야 하는 클래스 파일이 모두 있어야 한다.
    }

}
