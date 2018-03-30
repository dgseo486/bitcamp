package step12.ex2;

public class MyLinkedList {
    class Bucket{
        Object value;
        Bucket next;
        Bucket prev;
    }
    
    Bucket head;
    Bucket tail;
    
    MyLinkedList(){
        head = new Bucket();
        tail = head;
    }
    
    void add(Object value) {
        tail.value = value;
        
        Bucket bucket = new Bucket();
        bucket.next = bucket;
        bucket.prev = tail;
        
        tail = bucket;
    }
    
    Object get(int index) {
        Bucket cursor = head;
        int count = 0;
        while(cursor != tail){
            if(count == index) {
                return cursor.value;
            }
            count++;
            cursor = cursor.next;
        }
        return null;
    }
    
    int size() {
        return;
    }
}
