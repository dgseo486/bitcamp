// 비트 이동 연산자 : >>, >>>, <<
package step04;

class Exam04_1 {
    public static void main(String[] args){
        int i = 1;
        //0000 0001
        System.out.println(i << 1); //2
        //0000 0010
        System.out.println(i << 2); //4
        //0000 0100
        System.out.println(i << 3); //8
        //0000 0100
        System.out.println(i << 4); //16
        //0000 1000
        //1비트 이동은 *2와 같다.

        i = 0b0000_1011; //11
        System.out.println(i << 1); //22 0001_0110
        System.out.println(i << 2); //44 0010_1100
        System.out.println(i << 3); //88 0101_1000
    }
}