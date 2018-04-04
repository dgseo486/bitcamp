// 상수 변수를 활용하여 분류 코드로 다루기
package step17.ex2;

public class Exam02_2 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        p.category = Appliance.TV;
        p.name = "울트라비전 뷰";
        p.price = 2000000;
        
        p.category = Book.ESSAY;
        p.category = Computer.MOUSE;
    }
}
