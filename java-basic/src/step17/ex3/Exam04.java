package step17.ex3;

import step17.ex3.ArrayList.MyIterator;

public class Exam04 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        
        MyIterator iterator = list.iterator();
        
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
