// Singleton 패턴 적용 후
package step09.singleton;

public class Car2 {

    private static Car2 instance;
    
    private Car2 () {
        System.out.println("Car2()");
    }
    
    public static Car2 getInstance() {
        if(instance == null) {
            instance = new Car2();
        }
        return instance;
    }

}
