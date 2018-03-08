// 논리 연산자 : 비트 연산
package step04;

class Exam03_5 {
    public static void main(String[] args){
        int a = 0b0110_1100;
        int b = 0b0101_0101;

        System.out.println(a & b);
        System.out.print(a | b);
        System.out.print(a ^ b);
        System.out.print(~a);
    }
}