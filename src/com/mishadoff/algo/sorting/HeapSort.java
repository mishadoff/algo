package com.mishadoff.algo.sorting;

import com.mishadoff.algo.data.MaxHeap;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author mishadoff
 */
public class HeapSort extends Sort {

    @Override
    public void sort(int[] a) {
        MaxHeap heap = new MaxHeap(a);
        for (int i = a.length; i >= 1; i--) {
            int temp = heap.data[0];
            heap.data[0] = heap.data[heap.heapSize - 1];
            heap.data[heap.heapSize - 1] = temp;
            heap.heapSize--;
            heap.heapify(0);
        }
    }
}
