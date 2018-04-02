// 캡슐화(encapsulation) - setter와 getter
package step11.ex13;

import step11.ex13.sub.B;
import step11.ex13.sub.C;

public class Exam02_1 extends C {
    
    public static void main(String[] args) {
        A obj1 = new A();
        
        //obj1.privateVar = 100; //접근 불가
        obj1.dafaultVar = 100;
        obj1.protectedVar = 100;
        obj1.publicVar = 100;
        
        B obj2 = new B();
        
        //obj2.privateVar = 100; // 접근 불가
        //obj2.defaultVar = 100; // 접근 불가
        //obj2.protectedVar = 100; // 접근 불가
        obj2.publicVar = 100;
        
        C obj3 = new C();
        //obj3.privateVar = 100; // 접근 불가
        //obj3.defaultVar = 100; // 접근 불가
        //obj3.protectedVar = 100;
        obj3.publicVar = 100;
        
        Exam02_1 obj4 = new Exam02_1();
        //obj4.privateVar = 100;
        //obj4.dafaultVar = 100;
        obj4.protectedVar = 100;
        obj4.publicVar = 100;
    }
}
