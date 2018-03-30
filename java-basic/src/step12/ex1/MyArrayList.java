package step12.ex1;

public class MyArrayList {
    final static int DEFAULT_CAPACITY = 5;

    Object[] list;
    int cursor;

    MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    MyArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            list = new Object[DEFAULT_CAPACITY];
        } else {
            list = new Object[capacity];
        }
    }

    void add(Object value) {
        if (cursor >= list.length) {
            this.increaseArray();
        }
        list[cursor++] = value;
    }

    void add(int index, Object value) {
        if (index < 0 || index > cursor) {
            return;
        }
        if (cursor >= list.length) {
            this.increaseArray();
        }
        for (int i = cursor - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        cursor++;
        list[index] = value;
    }

    Object get(int index) {
        return list[index];
    }

    void set(int index, Object value) {
        list[index] = value;
    }

    void remove(int index) {
        if (index < 0 || index >= cursor) {
            return;
        }
        for (int i = index + 1; i < cursor; i++) {
            list[i - 1] = list[i];
        }
        cursor--;
    }

    void increaseArray() {
        if (cursor >= list.length) {
            Object[] list2 = new Object[list.length + DEFAULT_CAPACITY];
            for (int i = 0; i < list.length; i++) {
                list2[i] = list[i];
            }
            list = list2;
        }
    }

    int size() {
        return cursor;
    }
    
    boolean contains(Object value) {
        for(Object obj : list) {
            if(obj.equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    int indexOf(Object value) {
        for(int i = 0; i < list.length; i++) {
            if(list[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

}
