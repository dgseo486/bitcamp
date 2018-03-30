// 제네릭 - 응용

package step13;

import java.util.HashMap;

import step11.ex12.Member;

public class Exam01_4 {
    HashMap map = new HashMap(); // Object key, Object value
    map.put("aaa", "1111");
    
    HashMap<Object, Object> map2 = new HashMap<>(); // 개발자에게 명확하게 Object 타입을 지정하는 것이 좋다.

    HashMap<String, Member> map3 = new HashMap<>();
    
    
}
