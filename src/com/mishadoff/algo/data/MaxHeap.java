package com.mishadoff.algo.data;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author mishadoff
 */
public class MaxHeap {
    public int[] data;
    public int heapSize;

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
}
