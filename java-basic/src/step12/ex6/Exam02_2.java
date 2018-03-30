package step12.ex6;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Exam02_2 {
    
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
        map.put("s04", v5);
        
        Set entrySet = map.entrySet();
        
        for(Object obj : entrySet) {
            Entry entry = (Entry) obj;
            System.out.printf("%s ==> %s\n", entry.getKey(), entry.getValue());
        }
        
    }
}
