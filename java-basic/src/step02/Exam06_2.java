// 문자 변수 - UTF-16(Unicode 2) 코드 값 저장
package step02;

class Exam06_2 {
    public static void main(String[] args){
        char c1, c2, c3;
        c1=0x41;
        c2=65;
        //c3=0d0100_0001;
        System.out.println(c1);
        System.out.println(c2);
        //System.out.println(c3);

        char c4;
        c4='핳';
        System.out.println(c4);

        int c5;
        c5='핳'; //10진수
        System.out.println(c5);

        char c6;
        c6=0xd573; //16진수
        System.out.println(c6);
    }
}