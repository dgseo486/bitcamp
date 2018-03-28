//Object 클래스의 메서드를 오버라이딩 하기 - hashCode()
package step11.ex12;

public class Exam02_2 {
    
    static class Score{
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.sum = kor + eng + math;
            this.aver = this.sum / 3f;
        }
        
        //인스턴스가 다르더라도 값이 같으면 같은 해 값을 리턴하로독 오버라이딩 해보자
        @Override
        public int hashCode() {
            String value = String.format("%s, %d, %d, %d, %d, %.1f", 
                    this.name, this.kor, this.eng, this.math, this.sum, this.aver);
            return value.hashCode();
        }
    }
    
    public static void main(String[] args) {
        Score s1 = new Score("홍길동", 100, 100, 100);
        Score s2 = new Score("홍길동", 100, 100, 100);
        
        //같은 값을 가질 때 같은 해시값을 리턴하도록 
        //hashCode()를 오버라이딩 했기 때문에 
        //다음 출력은 같은 해시 값을 출력할 것이다.
        System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
        
        System.out.println(s1.hashCode() == s2.hashCode());
    }
    
}
