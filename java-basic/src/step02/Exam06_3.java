// 문자 변수 - UTF-16(Unicode 2) 코드
package step02;

class Exam06_3 {
    public static void main(String[] args){
        int a=0xac00;
        System.out.println(a);

        System.out.println((char)a);

        for (int i=0; i<100; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print((char)('가'+i));
        }
    }
}