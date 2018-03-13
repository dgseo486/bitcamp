package step05.assignment;

import java.util.Scanner;

class test03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = sc.nextInt();
        
        int starlen = 1;
        while(starlen <= len){
            int spaceCnt = 1;
            int spaceLen = (len - starlen) / 2;
            while (spaceCnt <= spaceLen) {
                System.out.print(" ");
                spaceCnt++;
            }
            int starCount = 1;
            while(starCount <= starlen){
                System.out.print("*");
                starCount++;
            }
            System.out.println();
            starlen+=2;
        }
    }
}