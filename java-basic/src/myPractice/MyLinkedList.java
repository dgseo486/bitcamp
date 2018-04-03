package myPractice;

public class MyLinkedList {
    
    class Bucket{
        Object value;
        Bucket prev;
        Bucket next;
    }
    
    Bucket head;
    Bucket tail;
    
    public MyLinkedList() {
        head = new Bucket();
        tail = head;
    }
    
    public void add(Object value) {
        tail.value = value;
        Bucket bucket = new Bucket();
        tail.next = bucket;
        bucket.prev = tail;
        tail = bucket;
    }
    
    public void add(int index, Object value) {
        Bucket cursor = head;
        int count = 0;
        
        while(cursor != tail) {
            if(count == index) {
                Bucket bucket = new Bucket();
                bucket.value = value;
                
                bucket.prev = cursor.prev;
                cursor.prev = bucket;
                bucket.next = cursor;
                if(bucket.prev != null) {
                    cursor.prev.next = bucket;
                } else {
                    head = bucket;
                }
                return;
            }
            count++;
            cursor = cursor.next;
        }
        
        if(count == index) {
            add(value);
        }
    }
    
    public Object get(int index) {
        Bucket cursor = head;
        int count = 0;
        while(cursor != tail) {
            if(count == index) {
                return cursor.value;
            }
            count++;
            cursor = cursor.next;
        }
        return null;
    }
    
    public int size() {
        Bucket cursor = head;
        int count = 0;
        while(cursor != tail) {
            count++;
            cursor = cursor.next;
        }
        return count;
    }
    
    public Object remove(int index) {
        Bucket cursor = head;
        
        if(index == 0) {
            if(head == tail) {
                return null;
            } else {
                head.next = head;
                head.prev = null;
                return cursor.value;
            }
        }
        
        int count = 0;
        while(cursor != tail) {
            if(count == index) {
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                return cursor.value;
            }
            count++;
            cursor = cursor.next;
        }
        return null;
    }
}
