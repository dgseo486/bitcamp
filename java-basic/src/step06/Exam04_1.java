// 메서드 : 스택 메모리와 힙 메모리
package step06;

class Exam04_1 {

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("swap(): a=%d, b=%d\n", a, b);
    }

    public static void main(String[] args){
        int a = 100;
        int b = 200;
        swap(a, b);
        System.out.printf("swap(): a=%d, b=%d\n", a, b);
    }
}