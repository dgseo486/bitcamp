package bitcamp.java106.pms;

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        class Info {
            String teamName;
            String teamDescription;
            String maxQty;
            String startDate;
            String endDate;
        }

        Info[] infos = new Info[5];
        int now = 0;

        for(int i = 0; i < 5; i++){
            infos[i] = new Info();
            System.out.print("팀명? ");
            infos[i].teamName = keyScan.nextLine();
            System.out.print("설명? ");
            infos[i].teamDescription = keyScan.nextLine();
            System.out.print("최대인원? ");
            infos[i].maxQty = keyScan.nextLine();
            System.out.print("시작일? ");
            infos[i].startDate = keyScan.nextLine();
            System.out.print("종료일? ");
            infos[i].endDate = keyScan.nextLine();
            
            System.out.print("계속 입력하시겠습니까?(Y/N) ");
            String flag = keyScan.nextLine();
            if(flag.charAt(0) == 'N' || flag.charAt(0) == 'n'){
                now = i;
                break;
            }
        }
        
        System.out.println("------------------------------------");
        for(int i = 0; i < now+1; i++){
            System.out.println(infos[i].teamName + ", " + infos[i].maxQty + "명" + ", " + infos[i].startDate + " ~ " + infos[i].endDate);
        }
    }
}