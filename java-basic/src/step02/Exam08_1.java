// 형변환 - 크기가 다른 변수의 값을 저장할때
package step02;

class Exam08_1 {
    public static void main(String[] args) {
        byte b = 100;
        short s = 100;
        int i = 100;
        long l = 100;
        char c = 100;

        byte b2;
        short s2;
        int i2;
        long l2;
        char c2;

        // 큰 변수의 값을 작은 변수에 넣을 수 없다.
        b2 = s;
        s2 = i;
        i2 = l;
        c2 = s;
    }
}