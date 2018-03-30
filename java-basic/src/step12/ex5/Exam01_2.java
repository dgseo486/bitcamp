// java.util.Hashset 클래스 사용
package step12.ex5;

import java.util.ArrayList;

public class Exam01_2 {

    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        ArrayList set = new ArrayList();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        
        print(set);
    }
    
    static void print(ArrayList set) {
        Object[] values = set.toArray();
        for(Object value : values) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }
    
}
