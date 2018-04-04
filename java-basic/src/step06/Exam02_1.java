// 메서드 : 개념 및 기본 문법
package step06;

class Exam02_1 {

    static void hello() {
        System.out.println("안녕하세요.");
        System.out.println("이 메서드는 어떤 값도 리턴하지 않습니다.");
    }

    public static void main(String[] args){
        hello();
        System.out.println("hello() 실행 완료!");

        //hello(100); //컴파일 오류!

        // int i;
        // i = hello(); //컴파일 오류!
    }
}