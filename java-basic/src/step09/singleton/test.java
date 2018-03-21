// Singleton 패턴 - 객체를 한개만 생성하도록 만드는 설계 기법
package step09.singleton;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // singleton을 적용하지 않은 클래스의 인스턴스 만들기
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        
        System.out.println("------------------------");
        
        //Car2 클래스의 생성자는 접근할 수 없기 때문에 호출할 수 없다.
        //Car2 c1 = new Car2();
        
        Car2 x1 = Car2.getInstance();
        Car2 x2 = Car2.getInstance();
        Car2 x3 = Car2.getInstance();
        
        if(x1 == x2) {
            System.out.println("x1 == x2");
        }
        if(x2 == x3) {
            System.out.println("x2 == x3");
        }
    }

}
