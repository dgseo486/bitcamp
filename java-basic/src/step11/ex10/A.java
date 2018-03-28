package step11.ex10;

public class A {
    public static void m() {
        System.out.println("m()");
    }
    
    public static void m(int a) {
        System.out.println("m(int)");
    }
    
    public static void m(String a) {
        System.out.println("m(String)");
    }
    
    public static void m(String a, int b) {
        System.out.println("m(String, int)");
    }
    
    public static void m(int a, String b) {
        System.out.println("m(int, String)");
    }
    
    // 변수의 이름만 다른 메서드를 중복해서 만들 수 없다.
    /*public static void m(int x, String y) {
        System.out.println("m(int, String)");
    }*/
    
    //리턴 타입만 다른 메서드를 중복해서 만들 수 있다.
    /*public static int m(int a, String b) {
        return 0;
    }*/
    
    
}
