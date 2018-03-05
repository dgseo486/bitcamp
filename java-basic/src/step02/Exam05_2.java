// 부동소수점 변수 - 단정도와 배정도
package step02;

class Exam05_2 {
    public static void main(String[] args){
        float f;
        double d;

        f=9876.98769876f;
        d=9876.98769876f;

        System.out.println(f);
        System.out.println(d);

        f=9876.98769876f;
        // double 변수에 리터럴 값을 넣을 때는 8바이트 부동소수점 리터럴을 넣어라
        // 리터럴 뒤에 f나 F를 붙이지 말라
        d=9876.98769876;

        System.out.println(f);
        System.out.println(d);
    }
}