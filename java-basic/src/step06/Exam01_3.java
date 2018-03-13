// 메서드 : 리팩토링
package step06;

import java.util.Scanner;

class Exam01_3 {
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

    public static int getSpaceLength(int totalStar, int displayStar){
        return (totalStar - displayStar) / 2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = sc.nextInt();
        
        for (int starlen = 1; starlen <= len; starlen += 2){
            printSpaces(getSpaceLength(len, starlen));
            printStars(starlen);
            System.out.println();
        }
    }
}