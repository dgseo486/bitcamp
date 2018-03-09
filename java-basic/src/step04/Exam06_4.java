// 증감 연산자 : 후위(post-fix) 증감 연산자 응용 2
package step04;

class Exam06_4 {
    public static void main(String[] args){
        int i = 2;
        int result = i++ + i++ * i++;
        System.out.printf("%d, %d\n", i, result);
    }
}