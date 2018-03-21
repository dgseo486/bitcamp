package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        System.out.print("년,월,일?(예: 2018 3 21) ");

        int y = sc.nextInt();
        int m = sc.nextInt() - 1;
        int d = sc.nextInt();
        
        Calendar c = Calendar.getInstance();
        c.set(y, m, d);

        String[] weeks = {"", "일", "월", "화", "수", "목", "금", "토"};
        System.out.printf("요일: %s요일\n", weeks[c.get(Calendar.DAY_OF_WEEK)]);

        System.out.printf("주차: %d주차\n", c.get(Calendar.WEEK_OF_MONTH));

        System.out.printf("일차: %d일차\n", c.get(Calendar.DAY_OF_YEAR));
    }

    /*switch (c.get(Calendar.DAY_OF_WEEK)) {
        case 1:
            System.out.println("요일: 일요일");
            break;
        case 2:
            System.out.println("요일: 월요일");
            break;
        case 3:
            System.out.println("요일: 화요일");
            break;
        case 4:
            System.out.println("요일: 수요일");
            break;
        case 5:
            System.out.println("요일: 목요일");
            break;
        case 6:
            System.out.println("요일: 금요일");
            break;
        case 7:
            System.out.println("요일: 토요일");
            break;
        }*/
}
