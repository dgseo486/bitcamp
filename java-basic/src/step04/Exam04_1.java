// 비트 이동 연산자 : >>, >>>, <<
package step04;

class Exam04_1 {
    public static void main(String[] args){
        boolean a = true;
        boolean b = false;
        boolean r = a || (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);

        a = true;
        b = false;
        r = a & (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
    }
}