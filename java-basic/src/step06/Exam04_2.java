// 메서드 : Heap 메모리 영역
package step06;

class Exam04_2 {

    static int[] getArray() {
        int[] arr = new int[]{100, 200, 300};
        return arr;
    }

    public static void main(String[] args){
        int[] arr;
        arr = getArray();
        System.out.println(arr[1]); //200
    }
}

// getArray()로 생성한 배열은 인스턴스가 생성되기 때문에 Heap 메모리 영역에 저장된다.
// main()에선 그 reference 주소값을 저장하고 있기 때문에 Method가 끝나더라도 배열을 
// 계속 사용할 수 있다.