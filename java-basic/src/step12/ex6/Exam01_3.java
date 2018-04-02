package step12.ex6;

import java.util.HashMap;

public class Exam01_3 {
    
    static class MyKey {
        String major;
        int no;
        
        public MyKey(String major, int no) {
            this.major = major;
            this.no = no;
        }
        
        @Override
        public String toString() {
            return "MyKey [major=" + major + ", no=" + no + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((major == null) ? 0 : major.hashCode());
            result = prime * result + no;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MyKey other = (MyKey) obj;
            if (major == null) {
                if (other.major != null)
                    return false;
            } else if (!major.equals(other.major))
                return false;
            if (no != other.no)
                return false;
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("윤봉길", 25);
        
        HashMap map = new HashMap();
        
        MyKey k1 = new MyKey("컴공", 1);
        MyKey k2 = new MyKey("컴공", 2);
        MyKey k3 = new MyKey("컴공", 3);
        MyKey k4 = new MyKey("컴공", 4);
        MyKey k5 = new MyKey("컴공", 5);
        
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        
        System.out.println(map.get(k1));
        System.out.println(map.get(k2));
        System.out.println(map.get(k3));
        System.out.println(map.get(k4));
        System.out.println(map.get(k5));
        
        MyKey k6 = new MyKey("컴공", 3);
        System.out.println(map.get(k6));
    }
}
