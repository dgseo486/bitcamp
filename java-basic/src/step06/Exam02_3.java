// 메서드 : 개념 및 기본 문법3
package step06;

import java.util.Scanner;

class Exam02_3 {

    static String hello() {
        return "안녕하세요!";
    }

    public static void main(String[] args){
        String r = hello();
        System.out.println(r);

        hello();

        //int i = hello(); // 컴파일 오류!
    }
}