package lianxi20220815;

import lianxi20220814.Solution2;

class MyCircularDeque {

    int begin = 0;
    int end = 0;
    int capacity = 0;
    int[] doubleQueue = null;

    public MyCircularDeque(int k) {
        capacity = k+1;
        doubleQueue = new int[k+1];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        begin = (begin - 1 + capacity) % capacity;
        doubleQueue[begin] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        doubleQueue[end] = value;
        end = (end + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        begin = (begin  + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        doubleQueue[end] = 0;
        end = (end -1+ capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return doubleQueue[begin];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return doubleQueue[(end - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return begin == end;
    }

    public boolean isFull() {
        System.out.println(end);
        System.out.println(begin);
        return (end+1) % capacity == begin;
    }

    public static void main(String[] args) {
        MyCircularDeque mcd = new MyCircularDeque(3);
        mcd.insertLast(1);
        mcd.insertLast(2);
        System.out.println(mcd.insertFront(3));
    }

}