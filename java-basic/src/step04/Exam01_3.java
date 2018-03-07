// 산술 연산자 : 암시적 형변환
package step04;

class Exam01_3 {
    public static void main(String[] args){
        byte b = 5 + 6;
        
        byte x = 5, y = 6, z;
        z = x + y; // 컴파일 오류

        short s1 = 5;
        short s2 = 6;
        short s3 = s1 + s2; // 컴파일 오류
    }
}