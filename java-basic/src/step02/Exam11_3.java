// 변수의 범위 - 변수의 중복
package step02;

class Exam11_3 {
    
    int a;
    static int b;

    // 중복 선언 불가
    //int a;
    //static int a;

    public static void main(String[] args) {
        // 메서드에서 클래스에 선언된 변수의 이름과 같은 변수를 선언할 수 있다.
        int a;
        int b;

        //String a; // 데이터타입에 상관없이 이름 중복 불가
    }

    public static void m2() {
        int a; 
        int b;
    }
}