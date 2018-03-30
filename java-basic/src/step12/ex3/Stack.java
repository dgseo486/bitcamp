package step12.ex3;

import step12.ex2.LinkedList;

public class Stack extends LinkedList {
    public void push(Object value) {
        this.add(value);
    }
    
    public Object pop() {
        if(this.head == this.tail) {
            return null;
        }
        
        Bucket removedBucket = this.tail.prev;
        if(this.tail.prev.prev != null) {
            this.tail.prev.prev.next = tail;
            this.tail.prev = this.tail.prev.prev;
        } else {
            head = tail;
            head.prev = null;
        }
        
        return removedBucket.value;
    }
}
