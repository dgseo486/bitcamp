// 정수 변수 - 정수 리터럴과 정수 변수
package step02;

class Exam04_1 {
    public static void main(String[] args){
        byte b;
        b = -128;
        b = 127;
        
        //b = -129; //컴파일 오류
        //b = 128; //컴파일 오류
        
        short s;
        s = -32768;
        s = 32767;
        
        //s = -32769; //컴파일 오류
        //s = 32768; //컴파일 오류

        int i;
        i = -2147483648;
        i = 2147483647;
        
        //i = -2147483649; //4바이트 크기를 넘어가는 수를 표현했기 때문에 오류
        //i = 2147483648; //4바이트 크기를 넘어가는 수를 표현했기 때문에 오류

        //i = -2147483649L; //'L'을 붙임으로서 값을 저장했지만 데이터에 손실이 발생
        //i = 2147483648L;

        long l;
        //l = -9223372036854775808L;
        //l = 9223372036854775807L;

        byte b2;
        b2 = 100;
        b2 = 100L; //4바이트 리터럴만 byte나 short 메모리에 유효한 범위의 값을
                   //저장할 수 있게 허락한다.
    }
}