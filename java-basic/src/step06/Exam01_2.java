// 메서드 : 사용 후
package step06;

import java.util.Scanner;

class Exam01_2 {

    // 스페이스 출력 기능
    public static void printSpaces (int len) {
        for(int i = 0; i < len; i++){
            System.out.print(" ");
        }
    }

    public static void printStars (int len) {
        for(int i = 0; i < len; i++){
            System.out.print("*");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = sc.nextInt();
        
        for (int starlen = 1; starlen <= len; starlen += 2){
            printSpaces((len - starlen) / 2);
            printStars(starlen);
            System.out.println();
        }
    }
}