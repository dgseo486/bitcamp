// 인스턴스 메서드와 클래스 메서드의 활용 - Date 클래스
package step09;

import java.util.Date;

public class Exam02_4 {

    public static void main(String[] args) throws Exception {
        Date d1 = new Date();
        
        System.out.println(d1.getYear() + 1900);
        System.out.println(d1.getMonth() + 1);
        System.out.println(d1.getDate());
        
        
        long millis = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
        System.out.println(millis);
        
        long currMillis = System.currentTimeMillis();
        
        java.sql.Date today = new java.sql.Date(currMillis);
        String str = today.toString();
        System.out.println(str);
        
        java.sql.Date d = java.sql.Date.valueOf("2018-03-21");
    }

}
