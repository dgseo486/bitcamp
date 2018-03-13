// 흐름 제어문 - for 반복문과 컬렉션
package step05;

import java.util.ArrayList;

public class Exam04_4 {
    public static void main(String[] args) {
        //컬렉션은 다른 타입의 값을 보관할 수 있다.
        //컬렉션은 크기가 가변적이다.
        ArrayList list = new ArrayList();
        list.add("홍길동");
        list.add(3.14f);
        list.add(true);
        list.add(365);

        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        System.out.println("------------------------------");

        for (Object value : list)
            System.out.println(value);
        
    }
}