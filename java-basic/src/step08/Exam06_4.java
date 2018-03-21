// 스태틱 블록
package step08;

public class Exam06_4 {
    
    static class A {
        
        static int a;
        static void m() {}
        
        static {
            System.out.println("Static{} 1111");
        }
        
        static {
            System.out.println("Static{} 2222");
        }
    }
    
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        A obj1;
        A obj2;
        
        // 클래스가 로딩된 후에 스태틱 블록이 호출된다.
        
        // 1. 클래스 멤버를 최초로 사용할 때
        //A.a = 100;
        System.out.println("------------------");
        
        //A.m();
        System.out.println("******************");
        
        // 2. 해당 클래스의 인스턴스를 최초로 생성할 때
        new A();
        
        System.out.println("==================");
        // 3. 자바에서 제공하는 도구를 사용하여 강제로 클래스를 로딩시키는 경우
        // 이미 클래스가 로딩되어 있다면 다시 로딩되지 않는다.
        // 자바는 중복해서 클래스를 메모리에 로딩하지 않는다.
        Class.forName("step08.Exam06_4$A");
    }
}
