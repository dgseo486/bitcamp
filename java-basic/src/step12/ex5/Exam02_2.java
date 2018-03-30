// java.util.HashSet 클래스 사용 - 저장한 순서대로 꺼낼 수 없다.
package step12.ex5;

import java.util.HashSet;
import java.util.Iterator;

public class Exam02_2 {

    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        HashSet set = new HashSet();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        
        //set.get(0); //이런 메서드 없음
        
        // 값을 꺼내는 방법
        // 1) HashSet에 들어있는 값을 배열로 받아 사용한다.
        Object[] values = set.toArray();
        for(Object value : values) {
            System.out.println(value + ",");
        }
        System.out.println();
        
        //2) 창고에서 값을 꺼내주는 객체의 도움을 받는다.
        // HashSet에서 값을 꺼내는 객체를 얻는다.
        Iterator 컬렉션에서값을꺼내주는객체 = set.iterator();
        
        while(컬렉션에서값을꺼내주는객체.hasNext()) {
            System.out.print(컬렉션에서값을꺼내주는객체.next() + ", ");
        }
        System.out.println();
        
    }
    
}
