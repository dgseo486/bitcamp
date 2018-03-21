// String - "Hello" vs new String("Hello")
package step10;

public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // Heap 메모리 영역에 String 인스턴스를 생성하는 방법
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // 내용물의 동일 여부를 검사하지 않고 무조건 인스턴스를 생성.
        // 가비지가 되면 가비지 컬렉터에 의해 제거됨.
        
        //변수에 저장된 주소를 비교한다.
        if(s1==s2) {
            System.out.println("s1==s2");
        } else {
            System.out.println("s1!=s2");
        }
        
        // string constant pool 메모리 영역에 String 인스턴스 만들기
        String x1 = "Hello";
        String x2 = "Hello";
        // 내용물이 같은 기존 인스턴스의 주소를 리턴.
        // JVM이 끝날 때까지 메모리에 유지됨.
        
        //변수에 저장된 주소를 비교한다.
        if(x1==x2) {
            System.out.println("x1==x2");
        } else {
            System.out.println("x1!=x2");
        }
    }

}
