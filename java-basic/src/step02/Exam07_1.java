// 논리값 변수 - 유효한 값 범위
package step02;

class Exam07_1 {
    public static void main(String[] args){
        boolean b1, b2;
        b1 = true;
        b2 = false;

        System.out.println(b1);
        System.out.println(b2);

        b1 = 1; //컴파일 오류
        b2 = 2; //컴파일 오류
    }
}