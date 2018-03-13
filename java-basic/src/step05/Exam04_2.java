// 흐름 제어문 - for 반복문의 초기화 변수
package step05;

public class Exam04_2 {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) 
            System.out.println(i);

        System.out.println("-------------------------------------");
        //System.out.println(i);

        int x;
        for(x = 1; x <= 5; x++)
            System.out.println(x);
        System.out.printf("x=%d\n", x);
    }
}