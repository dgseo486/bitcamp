// 정수 변수 - 크기가 다른 변수끼리 값 할당
package step02;

class Exam04_2 {
    public static void main(String[] args){
        int i=100;
        byte b=100;
        
        // int(4byte) > byte(1byte)
        // 큰 크기의 변수를 작은 크기 변수에 저장할 수 없다.
        b=i; //컴파일 오류

        short s=100;
        s=i; //컴파일 오류

        int j=100;
        j=i;

        // 작은 크기의 변수를 큰 크기 변수에 저장할 수 있다.
        long l=100;
        l=i;

        int k;
        k=l; //컴파일 오류
    }
}