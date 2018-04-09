package step21.ex2;

public class Exam01_4 {
    public static void main(String[] args) {
        
        try {
            int result = Calculator3.compute("#", 100, 200);
            System.out.println(result);
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            
        }
        
        try {
            int result = Calculator3.compute("+", -2078654356, 866533144);
            System.out.println(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
