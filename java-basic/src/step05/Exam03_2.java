// 흐름 제어문 - break와 continue
package step05;

public class Exam03_2 {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;

        while (count < 100) {
            count++;
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("-----------------------------------------");
        
        // continue 사용 전
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if(count % 2 == 0){
                sum += count;
            }
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("-----------------------------------------");

        // continue 사용 후
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if(count % 2 == 1)
                continue;
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("-----------------------------------------");

        // break 사용 전
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if(count > 50)
                continue;
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("-----------------------------------------");

        // break 사용 후
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if(count > 50)
                break;
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);
    }
}