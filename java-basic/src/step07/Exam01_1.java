// 클래스 - 용도 2가지
package step07;

// 1. 사용자 정의 데이터 타입
class Student {
    String name;
    int age;
    String email;
    float weight;
    float heigh;
    String tel;
}

// 2. 메소드를 묶는 용도
class Calculator {
    public static int plus (int a, int b) { return a + b; }
    public static int minus (int a, int b) { return a - b; }
    public static int multiple (int a, int b) { return a * b; }
    public static int divide (int a, int b) { return a / b; }
}

public class Exam01_1 {
    public static void main(String[] args){
        Student ref = new Student();
        ref.name = "홍길동";
        ref.tel = "111-1111";
        ref.age = 20;

        int result = Calculator.plus(100, 200);
        int result2 = Calculator.minus(100, 200);   
    }
}