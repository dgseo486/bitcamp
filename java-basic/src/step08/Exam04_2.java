// 파라미터를 받는 생성자(Constructor)
package step08;

public class Exam04_2 {
    
    //Exam04_1(){} // 컴파일러가 자동 생성
    
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
        
        // 생성자가 한 개라도 있으면 컴파일러는 기본 생성자를 만들어주지 않는다.
        Score(String name, int kor, int eng, int math) {
            System.out.println("Score(String, int, int, int) 호출!");
            
            // 파라미터로 받은 값을 새로 만든 인스턴스 변수에 저장한다.
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.compute();
        }
        
        public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.average = this.sum / 3f;
        }
    }
    
    public static void main(String[] args) {
        // 기본 생성자가 없기 때문에 컴파일 오류
        //Score s0 = new Score();
        
        Score s1 = new Score("홍길동", 100, 90, 87);
        Score s2 = new Score("임꺽정", 80, 88, 87);
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.average);
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.average);
    }
}