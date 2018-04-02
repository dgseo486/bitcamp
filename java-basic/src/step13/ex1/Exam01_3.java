// 제네릭 사용 후

package step13.ex1;

import java.util.ArrayList;

import step11.ex12.Member;

public class Exam01_3 {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<Member>();
        ArrayList<Member> list2 = new ArrayList</*Member*/>();
        
        ArrayList<Member> list3;
        list3 = new ArrayList<>();
        
        // 제네릭 선언시 타입명 생략 불가
        //ArrayList<> list4;
    }
}
