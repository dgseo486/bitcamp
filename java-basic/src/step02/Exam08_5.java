// 형변환 - 명시적 형변환
package step02;

class Exam08_5 {
    public static void main(String[] args) {
        float f = 3.14f;
        double d = 9876.56789;

        int i = (int)f;
        long l = (long)d;

        //소수점 이하 제거
        System.out.println(i);
        System.out.println(l);
    }
}