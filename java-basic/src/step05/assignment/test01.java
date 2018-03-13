package step05.assignment;

import java.util.Scanner;

class test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int N = sc.nextInt();
        int count = 1;
        int i = 1;
        while(count <= N){
            while(i <= count){
                System.out.print("*");
                i++;
            }
            i = 1;
            System.out.println();
            count++;
        }
    }
}