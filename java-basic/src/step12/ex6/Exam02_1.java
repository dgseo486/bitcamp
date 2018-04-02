package step12.ex6;

import java.util.HashMap;
import java.util.Iterator;

public class Exam02_1 {
    
    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("윤봉길", 25);
        
        HashMap map = new HashMap();
        map.put("s01", v1);
        map.put("s02", v2);
        map.put("s03", v3);
        map.put("s04", v4);
        map.put("s05", v5);
        
        java.util.Set keys = map.keySet();
        
        Iterator 키를꺼내주는객체 = keys.iterator();
        while(키를꺼내주는객체.hasNext()) {
            Object key = 키를꺼내주는객체.next();
            System.out.println(map.get(key));
        }
        System.out.println("-----------------------------");
        
        Object[] keyArray = keys.toArray();
        for(Object key : keyArray) {
            System.out.println(map.get(key));
        }
        System.out.println("-----------------------------");
        
        for(Object key : keys) {
            System.out.println(map.get(key));
        }
        System.out.println("-----------------------------");
        
    }
}
