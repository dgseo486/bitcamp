// 배열 - 배열 선언과 사용
package step02;

class Exam09_1 {
    public static void main(String[] args) {
        int[] arr1 = new int[5]; //c++ style
        int arr2[] = new int[5]; //c style

        // 배열메모리 접근
        arr1[0] = 100;
        arr1[1] = 200;
        arr1[2] = 300;
        arr1[3] = 400;
        arr1[4] = 500;

        // 유효하지 않은 인덱스를 지정한다면?
        arr1[5] = 600; //실행할 때 오류 발생
    }
}

// 배열 : 같은 종류의 매모리를 쉽게 만드는 방법
// 문법
// 데이터타입[] 변수명 = new 데이터타입[개수];
// 
// 배열 메모리 접근
// 문법
// 배열변수[인덱스] = 값;
// 인덱스는 0 ~ (배열개수 - 1)