package step18.ex1;

import step11.ex05.A;

class X {
    static {
        System.out.println("X 클래스 로딩");
    }
}

class Y {
    static {
        System.out.println("Y 클래스 로딩");
    }
}

class Z {
    static {
        System.out.println("Z 클래스 로딩");
    }
}

public class Exam04 {
    public static void main(String[] args) throws Exception {
        Class.forName(args[0]);
        
        Class clazz = A.class;
    }
}
