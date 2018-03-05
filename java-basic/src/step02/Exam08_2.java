// 형변환 - 
package step02;

class Exam08_2 {
    public static void main(String[] args) {
        byte b = 100;
        short s = 100;
        int i = 100;
        long l = 100;
        char c = 100;

        byte b2;
        short s2;
        int i2;
        long l2;
        char c2;

        i2 = s; //short(2byte)->int(4byte)
        l2 = i; //int(4byte)->long(8byte)

        s2 = b; //byte(1byte)->short(2byte)
        i2 = c; //char(2byte)->int(4byte)

    }
}