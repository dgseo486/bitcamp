package step11.ex01;

public class Exam01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Car c = new Car();
        c.maker = "비트자동차";
        c.model = "티코";
        c.capacity = 5;
        
        Car c2 = new Car("비트자동차", "소나타", 5);
    }

}
