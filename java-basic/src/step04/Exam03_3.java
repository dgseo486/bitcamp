// 논리 연산자 : && vs &
package step04;

class Exam03_3 {
    public static void main(String[] args){
        boolean a = false;
        boolean b = false;
        boolean r = a && (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);

        a = false;
        b = false;
        r = a & (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
    }
}