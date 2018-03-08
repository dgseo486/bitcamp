// 산술 연산자 : 암시적 형변환
package step04;

class Exam01_5 {
    public static void main(String[] args){
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float f = 5.2f;
        double d = 6.6;
        char c = 7;
        boolean bool = true;

        //byte r1 = b + b;

        //short r2 = s + s;

        //short r3 = b + s;

        //최소 연산 단위가 int이다.

        int r4 = b + i;

        int r5 = s + i;

        //int r6 = i + l;

        //long r7 = l + f;

        //정수 타입의 값이 암시적 형변환을 통해 부동소수점으로 바뀐다.
        //int r8 = i + f;

        //float r9 = f + d;

        //double을 long에 넣을 수 없다.
        //long r10 = b + s + i + l + f + d;

        //long r11 = f + i + l;

        //int r12 = bool + i;
    }
}