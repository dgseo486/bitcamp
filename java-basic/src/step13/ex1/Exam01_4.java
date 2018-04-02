// 제네릭 - 응용

package step13.ex1;

import java.util.HashMap;

import step11.ex12.Member;

public class Exam01_4 {
    public static void main(String[] args) {
        HashMap map = new HashMap(); // Object key, Object value
        map.put("aaa", "문자열");
        map.put(new Integer(100), new Member("홍길동", 20));
        
        HashMap<Object, Object> map2 = new HashMap<>(); // 개발자에게 명확하게 Object 타입을 지정하는 것이 좋다.
        map2.put("aaa", "문자열");
        map2.put(new Integer(100), new Member("홍길동", 20));
        
        HashMap<String, Member> map3 = new HashMap<>();
        map3.put("aaa", new Member("홍길동", 20));
        
        Member m = map3.get("aaa");
        
    }
}
