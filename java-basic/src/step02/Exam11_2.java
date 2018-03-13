// 변수의 범위 - 종류에 따른 사용 범위
package step02;

class Exam11_2 {
    
    int a;
    static int b;

    public static void main(String[] args) {
        int c;
        b = 20;
    }

    public static void m2() {
        //static 매서드 = 클래스 매서드
        b = 20;
        //a = 100;
    }

    public void m3() {
        b = 20;
        a = 100;
    }

    public void m4() {
        b = 20;
        a = 100;
    }
}