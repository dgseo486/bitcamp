//다형성 - 다형적 변수와 형변환
package step11.ex09;

public class Exam03 {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        
        v1.model = "티코";
        v1.capacity = 5;
        
        Sedan s = (Sedan)v1;
        s.cc = 1980;
        s.valve = 16;
        s.sunroof = true;
        s.auto = true;
        System.out.printf("%s, %d, %d, %d, %b, %b\n", v1.model, v1.capacity, ((Sedan)v1).cc, ((Sedan)v1).valve,
                ((Sedan)v1).sunroof, ((Sedan)v1).auto);
    }

}
