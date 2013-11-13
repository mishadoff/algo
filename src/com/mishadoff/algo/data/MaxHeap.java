package com.mishadoff.algo.data;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author mishadoff
 */
public class MaxHeap<T extends Comparable<? super T>> {
    public T[] data;
    public int heapSize;

    public MaxHeap(T[] data) {
        this.data = data;
        heapSize = data.length;
        // building max heap
        for (int i = (heapSize - 1) / 2; i >=0; i--) {
            heapify(i);
        }
    }

    public void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int largest = index;
        if (left < heapSize && data[left].compareTo(data[index]) > 0) {
            largest = left;
        }
        if (right < heapSize && data[right].compareTo(data[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            T temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            heapify(largest);
        }
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * index + 2;
    }

    void print() {
        System.out.println(Arrays.toString(data));
    }

    // TEST -------------

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(new Integer[] { 1, 10, 3, 14, 7, 4, 16, 9, 2, 8});
        //MaxHeap heap = new MaxHeap(new int[] { 1, 10, 14, 7, 3, 5, 2});
        heap.print();
    }

}
