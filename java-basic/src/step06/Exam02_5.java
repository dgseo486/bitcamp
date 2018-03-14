// 메서드 : 가변 파라미터
package step06;

class Exam02_5 {

    // 다음은 hello()를 호출할 때 String 값을 0개 이상 전달 할 수 있다.
    static void hello(String... names) {
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s님 반갑습니다.\n", names[i]);
        }
    }

    public static void main(String[] args){
        hello();
        System.out.println("---------------------------");
        hello("홍길동");
        System.out.println("---------------------------");
        hello("홍길동", "임꺽정", "유관순");
    }
}