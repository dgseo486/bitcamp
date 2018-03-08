// 논리 연산자 : &&, ||, !(not), ^(XOR; eXclusive OR)
package step04;

class Exam03_1 {
    public static void main(String[] args) {
        //AND 연산자
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println("-----------------------------");
        //OR 연산자
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        System.out.println("-----------------------------");
        //NOT 연산자
        System.out.println(!true);
        System.out.println(!false);

        System.out.println("-----------------------------");
        //XOR 연산자
        //두 값이 다들 때 true
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(true ^ false);

    }
}