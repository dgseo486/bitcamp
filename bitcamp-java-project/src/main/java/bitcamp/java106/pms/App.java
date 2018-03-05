package bitcamp.java106.pms;

public class App{
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);
        
        System.out.print("팀명? ");
        String tName=keyScan.nextLine();
        System.out.print("설명? ");
        String tDes=keyScan.nextLine();
        System.out.print("최대인원? ");
        String num=keyScan.nextLine();
        System.out.print("시작일? ");
        String start=keyScan.nextLine();
        System.out.print("종료일? ");
        String end=keyScan.nextLine();
        System.out.println("---------------------------");
        System.out.println("팀명: "+tName);
        System.out.println("설명: "+tDes);
        System.out.println("최대인원: "+num+"명");
        System.out.println("일자: "+start+" ~ "+end);
    }
}