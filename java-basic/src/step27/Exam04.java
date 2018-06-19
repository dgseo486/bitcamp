// 람다 - 파라미터와 리턴 값이 있는 람다
package step27;

public class Exam04 {
    
    static interface Calculator {
        int compute(int a, int b);
    }
    
    static void test(Calculator c) {
        System.out.println(c.compute(100, 200));
    }

    public static void main(String[] args) {
        test((a, b) -> a + b);
        
        test(new Calculator() {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }
        });
        
        test((a, b) -> {
            int sum = 0;
            for(int i = 0; i <= b; i++) {
                sum += i;
            }
            return sum;
        });
        
        test(new Calculator() {
            public int compute(int a, int b) {
                int sum = 0;
                for(int i = 0; i <= b; i++) {
                    sum += i;
                }
                return sum;
            }
        });
    }

}
