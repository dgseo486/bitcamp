// 증감 연산자 : 전위(pre-fix) 증감 연산자 응용 2
package step04;

class Exam06_8 {
    public static void main(String[] args){
        int i = 2;
        int result = ++i + ++i * ++i;
        
        System.out.println(i);
    }
}