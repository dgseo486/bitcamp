// 산술 연산자 : 연산의 결과 타입
package step04;

class Exam01_4 {
    public static void main(String[] args){
        int i = 5;
        int j = 2;

        // r 변수에 넣기 전에 이미 결과는 정수 2가 된다.
        float r = i / j;
        System.out.println(r);
        
        // 형변환(type casting)
        r = (float)i / (float)j;
        System.out.println(r);

        int x = Integer.MAX_VALUE; // 0x7fffffff
        int y = Integer.MAX_VALUE;
        int r1 = x + y;
        long r2 = x + y;
        System.out.println(r1);
        System.out.println(r2);

        float f1 = 987.6543f;
        float f2 = 1.111111f;
        float r3 = f1 + f2;
        double r4 = f1 + f2; // float(4byte) 결과값을 double(8byte) 메모리에 저장하면서 왜곡발생.
        System.out.println(r3);
        System.out.println(r4);

        double d1 = 987.6543;
        double d2 = 1.111111;
        double r5 = d1 + d2; // 988.765411;
        System.out.println(r5);
    }
}

// int - int 연산은 int 타입 생성
// 변수에 들어있는 값을 꺼내 지정된 타입의 임시 메모리를 만들어 저장한다.