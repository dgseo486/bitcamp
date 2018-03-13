package step05.assignment;

import java.util.Scanner;

class test02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = sc.nextInt();
        int i = 1;
        while(i <= len){
            int j = 1;
            while(j <= i){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

        i = len - 1;
        while(i >= 1){
            int j = 1;
            while(j <= i){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i--;
        }
    }
}