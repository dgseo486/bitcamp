// 변수의 범위 - 변수와 블록
package step02;

class Exam11_4 {
    public static void main(String[] args){
        int a = 100;

        {
            //int a = 200; // 메서드 안에서 변수이름 중복 불가
            a = 200;
            int b = 300;
        }
        System.out.println(a);
        // 바깥 블룩에서는 안쪽 블록의 변수를 사용할 수 없다.
        System.out.println(b); // 컴파일오류

        {
            // 이전 블록에서 선언된 변수는 다른 블록에서 같은 변수명을 선언할 수 있다.
            int b = 400;
        }
    }    
}