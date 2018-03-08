// 관계 연산자 : <, <=, >, >=, ==, !=
package step04;

class Exam02_1 {
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        boolean r1 = a < b;
        //int r2 = a < b; // 컴파일오류

        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a == b);
        System.out.println(a != b);
    }
}