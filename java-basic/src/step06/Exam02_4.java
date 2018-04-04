// 메서드 : 개념 및 기본 문법4
package step06;

class Exam02_4 {

    static String hello(String name, int age) {
        String returnVal = String.format("%d살 %s님을 환영합니다.\n", age, name);
        return returnVal;
    }

    public static void main(String[] args){
        String r = hello("홍길동", 20);
        System.out.println(r);

        hello("임꺽정", 30);
    }
}