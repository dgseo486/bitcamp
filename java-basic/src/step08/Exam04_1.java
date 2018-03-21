// 특별한 인스턴스 메서드 - 생성자(Constructor)
package step08;

public class Exam04_1 {
    
    //Exam04_1(){} // 컴파일러가 자동 생성
    
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
        
        // 파라미터가 없는 생성자가 기본 생성자(default constructor)
        Score() {
            System.out.println("Score()");
        }
        
        public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.average = this.sum / 3f;
        }
    }
    
    public static void main(String[] args) {
        Score s1 = new Score();
        
        //Score s2 = new Score; // 생성자를 호출하지 않은 경우 컴파일 오류
        
        Score s3 = new Score();
    }
}
