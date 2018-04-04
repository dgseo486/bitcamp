// 스태틱 멤버와 import
package step17.ex2;

import static step17.ex2.Category2.*;

public class Exam04 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        
        //p.category = Category2.appliance.TV;
        p.category = appliance.TV;
        p.category = book.NOVEL;
        p.category = computer.MOUSE;
        
        p.name = "울트라비전 뷰";
        p.price = 2000000;
    }
}
