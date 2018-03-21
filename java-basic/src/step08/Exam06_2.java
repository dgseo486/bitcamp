// 초기화 블록 - 인스턴스 블록의 활용
package step08;

public class Exam06_2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object obj1 = new Object() {
            // 이 클래스는 이름이 없기 때문에 생성자를 만들 수 없다.
            // 그래서 초기화 명령을 작성하려면 인스턴스 블록을 이용해야 한다.
            {
                System.out.println("인스턴스 블록");
            }
        };
    }
}
