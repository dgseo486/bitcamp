// 메서드 : 가변 파라미터의 단점
package step06;

class Exam02_7 {

    //가변 파라미터는 여러 개 선언할 수 없다.
    /*
    static void m1(String... names, String... name2) {

    }
    */

    //가변 파라미터는 반드시 맨 끝에 와야 한다.
    /*
    static void m2(String... names, int a) {

    }
    */

    static void m3(int a, String... names) {

    }

    static void x1(String[] names, String[] names2) {
        
    }

    static void x2(String[] names, int a) {
        
    }

    public static void main(String[] args){
        
    }
}