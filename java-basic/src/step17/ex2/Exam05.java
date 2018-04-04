// 스태틱 멤버와 import
package step17.ex2;

import static step17.ex2.Category2.appliance.*;
import static step17.ex2.Category2.computer.*;
import static step17.ex2.Category2.book.*;

public class Exam05 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        
        p.category = TV;
        p.category = NOVEL;
        p.category = MOUSE;
        
        p.name = "울트라비전 뷰";
        p.price = 2000000;
    }
}
