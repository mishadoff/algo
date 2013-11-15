package com.mishadoff.algo.data;

import java.util.Arrays;

/**
 * @author mishadoff
 */
public class Stack {
    private int[] data;
    private int stackSize;

    private final static int MINIMUM = 4;

    public Stack() {
        data = new int[MINIMUM];
        stackSize = 0;
    }

    public int count() {
        return stackSize;
    }

    public int peek() {
        if (stackSize == 0) throw new RuntimeException("Stack is empty");
        return data[stackSize - 1];
    }

    public void push(int e) {
        if (data.length == stackSize) {
            grow(data.length * 2);
        }
        data[stackSize] = e;
        stackSize++;
    }

    public int pop() {
        if (stackSize == 0) throw new RuntimeException("Stack is empty");
        int e = data[stackSize - 1];
        stackSize--;
        if (stackSize <= data.length / 3 && stackSize > 0 && data.length > MINIMUM) {
            grow(data.length / 2);
        }
        return e;
    }

    private void grow(int length) {
        int[] data = new int[length];
        for (int i = 0; i < stackSize; i++) {
            data[i] = this.data[i];
        }
        this.data = data;
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    // TEST

    public static void main(String[] args) {
        Stack s = new Stack();
        s.print();
        s.push(1);
        s.print();
        s.pop();
        s.print();
        s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);
        s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);
        s.print();
        s.pop(); s.pop(); s.pop(); s.pop(); s.pop();
        s.print();
        s.pop(); s.pop(); s.pop();
        s.print();
    }
}
