//다형성 - 다형적 변수의 활용
package step11.ex09;

public class Exam04 {

    public static void printSedan(Sedan sedan) {
        System.out.printf("모델명: %s\n", sedan.model);
        System.out.printf("cc: %d\n", sedan.cc);
        System.out.printf("--------------------------------\n");
    }
    
    public static void printTruck(Truck truck) {
        System.out.printf("모델명: %s\n", truck.model);
        System.out.printf("cc: %d\n", truck.cc);
        System.out.printf("--------------------------------\n");
    }
    
    public static void printCar(Car car) {
        System.out.printf("모델명: %s\n", car.model);
        System.out.printf("cc: %d\n", car.cc);
        System.out.printf("--------------------------------\n");
    }
    
    public static void main(String[] args) {
        Sedan car1 = new Sedan();
        car1.model = "티코";
        car1.cc = 800;
        Truck car2 = new Truck();
        car2.model = "타이탄2";
        car2.cc = 10000;
        
        printSedan(car1);
        
        //printSedan()의 파라미터는 Sedan 객제의 주소만 받을 수 있다.
        //그래서 Truck 객체를 전달할 수 없다.
        //printSedan(car2); // 컴파일 오류
        printTruck(car2);
        
        printCar(car1);
        printCar(car2);
    }

}
