// 메서드 : 스택 메모리 응용2 - 재귀호출
package step06;

class Exam04_5 {
    static int sum(int value) {
        if(value == 1)
            return 1;
        return value + sum(value - 1);
    }

    public static void main(String[] args){
        System.out.println(sum(100));
        //System.out.println(sum(100000)); // 스택오버플로우 발생
    }
}