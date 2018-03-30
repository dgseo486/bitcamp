package step12.ex4;

import step12.ex2.LinkedList;

public class Queue extends LinkedList {
    
    public void offer(Object value) {
        this.add(value);
    }
    
    public Object poll() {
        return this.remove(0);
    }
    
}
