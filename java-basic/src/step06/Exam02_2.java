// 메서드 : 개념 및 기본 문법2
package step06;

import java.util.Scanner;

class Exam02_2 {

    static void hello(String name, int age) {
        System.out.printf("%d살 %s님 반값습니다.\n", age, name);
    }

    public static void main(String[] args){
        System.out.println("main() 1111111");
        hello("홍길동", 20);
        System.out.println("main() 2222222");
        hello("임꺽정", 19);
        System.out.println("main() 3333333");
        hello("유관순", 16);
        System.out.println("main() 4444444");

        //hello(윤봉길); // 컴파일 오류!
        //hello(20, 윤봉길); // 컴파일 오류!
        //String s = hello("안중근", 30); // 컴파일 오류!
        //void v = hello("안중근", 30); // 컴파일 오류!
    }
}