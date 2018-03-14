// 메서드 : 가변 파라미터 vs 배열 파라미터
package step06;

class Exam02_6 {

    static void hello(String... names) {
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s님 반갑습니다.\n", names[i]);
        }
    }

    static void hello2(String[] names) {
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
        System.out.println("---------------------------");
        String[] arr = {"홍길동", "임꺽정", "유관순", "김구"};
        hello(arr);
        //System.out.println("---------------------------");
        //hello2("홍길동", "임꺽정", "유관순"); // 배열에 담아서 전달해야 한다.
        System.out.println("---------------------------");
        String[] arr2 = {"홍길동", "임꺽정", "유관순", "김구"};
        hello2(arr);
    }
}