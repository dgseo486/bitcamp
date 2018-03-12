// 흐름 제어문 - if ~ else 문
package step05;

public class Exam01_4 {
    public static void main(String[] args) {
        int age = 17;

        if (age >= 19)
            System.out.println("성인입니다.");
        else
            System.out.println("미성년입니다.");

        // else 문만 단독으로 사용 불가
        /*
        else
            System.out.println("컴파일 오류");
        */

        // if와 else 문 사이에 다른 문장이 올 수 없다.
        /*
        if (age >= 19)
            System.out.println("성인입니다.");
        System.out.println("-----------------------------");
        else
            System.out.println("미성년입니다.");
        */

        // 블록에 들어 있는 문장은 if 문에 소속되기 때문에 상관없다.
        if (age >= 19){
            System.out.println("성인입니다.");
            System.out.println("-----------------------------");
        }
        else
            System.out.println("미성년입니다.");
    }
}