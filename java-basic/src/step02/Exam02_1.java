// 키보드 입력 받기
package step02;

class Exam02_1 {
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);
        System.out.print("팀명? ");
        System.out.println(keyScan.nextLine());
    }
}