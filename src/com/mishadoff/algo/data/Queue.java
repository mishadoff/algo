package com.mishadoff.algo.data;

import java.util.Arrays;

/**
 * @author mishadoff
 */
public class Queue {
    private int[] data;
    private int head;
    private int tail;

    private static final int MINIMUM = 4;

    public Queue() {
        data = new int[MINIMUM];
        head = 0;
        tail = 0;
    }

    public int count() {
        return (tail - head + data.length) % data.length;
    }

    public void enqueue(int e) {
        if (count() == data.length - 1) {
            grow(data.length * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length; // cyclic property
    }

    public int dequeue() {
        if (count() == 0) throw new RuntimeException("Queue is empty");
        int e = data[head];
        head = (head + 1) % data.length;
        if (count() <= data.length / 3 && count() > 0 && data.length > MINIMUM) {
            grow(data.length / 2);
        }
        return e;
    }

    private void grow(int length) {
        int[] data = new int[length];
        int t;
        for (t = 0; t < count(); t++) {
            data[t] = this.data[(head + t) % this.data.length];
        }
        this.data = data;
        head = 0;
        tail = t;
    }

    void print() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            if (head == i) {
                System.out.print(" { ");
            }
            if (tail == i) {
                System.out.print(" } ");
            }
            if (i > 0) System.out.print(" ");
            System.out.print(data[i]);
        }
        System.out.println("]");
    }

    // TEST

    public static void main(String[] args) {
        Queue q = new Queue();
        q.print();
        q.enqueue(1);
        q.print();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        q.dequeue();
        q.dequeue();
        q.print();
        q.enqueue(7);
        q.enqueue(8);
        q.print();
        q.enqueue(9);
        q.print();
        q.enqueue(10);
        q.print();
        q.dequeue();
        q.print();
        q.enqueue(11);
        q.print();
        // overflow
        q.enqueue(666);
        q.print();
        q.dequeue(); q.dequeue();
        q.print();
        q.dequeue();  q.dequeue();
        q.print();
    }
}
