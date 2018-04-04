// 흐름 제어문 - switch 문법
package step05;

public class Exam02_3 {
    public static void main(String[] args) {
        // switch (값) {}
        // 값으로 가능한 데이터 타입은?
        // int 정수(byte, short, int, char), 문자열, 특별한 상수 enum 타입
        // case 값으로 변수를 사용할 수 있다. 리터럴만 가능하다.
        byte b = 2;
        switch (b) {
        case 1:
        case 2:
        default:
        }

        short s = 2;
        switch (s) {
        case 1:
        case 2:
        default:
        }

        int i = 2;
        switch (i) {
        case 1:
        case 2:
        default:
        }

        //컴파일 오류, 4바이트 크기만 가능
        /*long l = 2;
        switch (l) {
        case 1:
        case 2:
        default:
        }
        */

        char c = 'A'; // A문자의 유니코드 값(UTF-16) 0x41(65)을 c에 저장한다.
        switch (c) {
        case 'A': //x41(16진수) or 65(10진수)도 가능
        case 66:
        case 0x43:
        default:
        }

        String str = "Apple";
        switch (str) {
        case "Banana":
        case "Apple":
        case "Orange":
        default:
        }

        //컴파일오류 boolean 값 사용 불가
        /*
        boolean bool = true;
        switch (bool) {
        case true;
        case false;
        }
        */

        int x = 1, y = 300;
        switch (x) {
        case 1 * 300:
        //case 1 * y:
        }
    }
}