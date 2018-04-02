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
        Bucket cursor = head;
        int count = 0;
        while(cursor != tail) {
            count++;
            cursor = cursor.next;
        }
        return count;
    }
    
    Object remove(int i) {
        Bucket cursor = head;
        
        if(i == 0) {
            if(head == tail) {
                return null;
            } else {
                head = head.next;
                return head.value;
            }
        }
        
        int count = 0;
        while(cursor != tail) {
            if(count == i) {
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                return cursor.value;
            }
            count++;
            cursor = cursor.next;
        }
        
        return null;
    }
    
    void add(int i, Object value) {
        Bucket cursor = head;
        int count = 0;
        
        while(cursor != tail) {
            if(count == i) {
                Bucket bucket = new Bucket();
                bucket.value = value;
                bucket.prev = cursor.prev;
                cursor.prev = bucket;
                bucket.next = cursor;
                if(bucket.prev != null) {
                    bucket.prev.next = bucket;
                } else {
                    head = bucket;
                }
                return;
            }
            count++;
            cursor = cursor.next;
        }
        
        if(count == i) {
            add(value);
        }
    }
    
}
