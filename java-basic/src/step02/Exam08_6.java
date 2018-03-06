// 형변환 - 명시적 형변환 2
package step02;

class Exam08_6 {
    public static void main(String[] args) {
        byte b = 100;
        short s = 100;
        int i = 100;
        long l = 100;

        byte b2 = (byte)s; // 명시적 형변환
        System.out.println(b2);

        b2 = (byte)i; // 명시적 형변환
        System.out.println(b2);

        b2 = (byte)l;
        System.out.println(b2); // 명시적 형변환

        // 메모리보다 큰 메모리를 저장하려 할 때 값 손실 발생
        int i2 = 0b0001_0010_1100; //=300(10진수)
        b2 = (byte) i2;
        System.out.println(b2);

        //큰 메모리를 바이트 단위로 자르고 싶을 때 사용
    }
}