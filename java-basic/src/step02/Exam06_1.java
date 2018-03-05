// 문자 변수 - 유효한 값 범위
package step02;

class Exam06_1 {
    public static void main(String[] args){
        char c;
        c=0;
        c=65535;

        c=-1; //컴파일 오류
        c=65536; //컴파일 오류
    }
}