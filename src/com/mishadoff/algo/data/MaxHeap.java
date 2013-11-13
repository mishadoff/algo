package com.mishadoff.algo.data;

import java.util.Arrays;

/**
 * @author mishadoff
 */
public class MaxHeap {
    private int[] data;
    int heapSize;

    public MaxHeap(int[] data) {
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
        if (left < heapSize && data[left] > data[index]) {
            largest = left;
        }
        if (right < heapSize && data[right] > data[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = data[index];
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
        MaxHeap heap = new MaxHeap(new int[] { 1, 10, 3, 14, 7, 4, 16, 9, 2, 8});
        //MaxHeap heap = new MaxHeap(new int[] { 1, 10, 14, 7, 3, 5, 2});
        heap.print();
    }

}
