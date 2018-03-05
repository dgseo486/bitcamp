// 부동소수점 변수 - 값 할당
package step02;

class Exam05_1 {
    public static void main(String[] args){
        // 유효자릿수 7자리 부동소수점 저장 가능
        float f;

        f=9.876545f;
        System.out.println(f);

        f=987654.5f;
        System.out.println(f);

        // 유효자릿수는 소수점을 제외한 숫자의 개수이다.
        f=0.000009876545f;
        System.out.println(f);

        // 정수 -> 부동소수점
        f=987654500;
        System.out.println(f);
    }
}