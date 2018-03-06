// 배열 - 배열 레퍼런스와 배열 인스턴스
package step02;

class Exam09_3 {
    public static void main(String[] args) {
        int[] arr1; // 레퍼런스 변수

        // new 명령은 메모리를 확보하는 명령이다.
        // 리턴 값은 확보된 메모리의 시작 주소이다.
        // 값을 저장하기 위해 확보된 메모리를 인스턴스라 부른다.
        arr1 = new int[5];

        arr1[0] = 100; // arr1에 저장된 주소로 찾아가서 0번째 항목에 값을 넣어라.

        arr1[1] = 200;
        
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        int a;
        //System.out.println(a); // 컴파일 오류

        //하지만 new 명령으로 확보된 메모리는 자동으로 0 으로 초기화 된다.
        System.out.println(arr1[2]);
        System.out.println(arr1[3]);
        System.out.println(arr1[4]);
        
    }
}

//레퍼런스란?
//값이 아닌 메모리의 주소를 담는 변수
//
//인스턴스란?
//값을 저장하고 있는 메모리