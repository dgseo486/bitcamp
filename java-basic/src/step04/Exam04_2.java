// 비트 이동 연산자 : >>, >>>, <<
package step04;

class Exam04_2 {
    public static void main(String[] args){
        int i = 0b01101000;
        System.out.println(i); //104
        System.out.println(i >> 1); // 00110100
        System.out.println(i >> 2); // 00011010
        System.out.println(i >> 3); // 00001101
        System.out.println(i >> 4); // 00000110
        // 1비트 오른쪽 이동은 나누기 2 한 것과 같다.

        i = 0b11111111_11111111_11111111_10101001;
        System.out.println(i); //-87
        System.out.println(i >> 1);
        System.out.println(i >> 2);
        System.out.println(i >> 3);
        System.out.println(i >> 4);
        //2로 나눈 후에 소수점이 있으면 그 수보다 더 작은 음수가 되는 효과가 있다.
    }
}
