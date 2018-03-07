package step03.assignment;

public class test01 {
    public static void main(String[] args) {
        java.util.Scanner keyScan = new java.util.Scanner(System.in);
        
        step03.Score[] scores = new step03.Score[3];
        for(int i = 0; i < scores.length; i++){
            scores[i] = new step03.Score();

            System.out.print("입력: ");
            scores[i].name = keyScan.next();
            scores[i].kor = keyScan.nextInt();
            scores[i].eng = keyScan.nextInt();
            scores[i].math = keyScan.nextInt();
            scores[i].sum = scores[i].sum + scores[i].eng + scores[i].math;
            scores[i].avg = scores[i].sum / 3;
        }

        System.out.println("-------------------------------------------");

        for(int i = 0; i < scores.length; i++){
            System.out.printf("%s %3d %3d %3d %3d %5.1f\n", scores[i].name, 
            scores[i].kor, scores[i].eng, scores[i].math, 
            scores[i].sum, scores[i].avg);
        }
        
    }
}