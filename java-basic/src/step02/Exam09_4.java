// 배열 - 배열 레퍼런스와 배열 인스턴스의 관계
package step02;

class Exam09_4 {
    public static void main(String[] args) {
        int[] arr1;
        arr1 = new int[]{100, 200, 300};

        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);

        // 새로운 int 배열을 확보하여 arr1 레퍼런스에 그 주소를 확보한다.
        // arr1 변수에 새 배열 주소 저장
        // 기존 배열은 주소를 잃고 사용할 수 없다.
        // 사용할 수 없는 메모리(인스턴스)를 garbage라 부른다.
        // garbage는 개발자가 임의로 제거할 수 없다.
        // garbage collector만이 garbage를 해제할 수 있다.
        arr1 = new int[]{10, 20, 30, 40, 50};
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
    }
}

// 가비지 컬렉터
// 인스턴스의 주소를 알고 있는 변수가 없을 경우
// 그 인스턴스는 가비지로 간주된다.
// 
// 가비지 컬렉터 실행
// 1.메모리가 부족한 경우
// 2.CPU가 한가할 때
// 3.개발자가 가비지 컬렉터를 실행해 달라고 요청할 경우