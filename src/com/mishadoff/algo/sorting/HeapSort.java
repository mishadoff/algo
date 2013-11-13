package com.mishadoff.algo.sorting;

import com.mishadoff.algo.data.MaxHeap;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author mishadoff
 */
public class HeapSort extends Sort {

    @Override
    public <T> void sort(T[] a, Comparator<T> comp) {
        throw new IllegalArgumentException("Not implemented");
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] a) {
        MaxHeap<T> heap = new MaxHeap<T>(a);
        for (int i = a.length; i >= 1; i--) {
            T temp = heap.data[0];
            heap.data[0] = heap.data[heap.heapSize - 1];
            heap.data[heap.heapSize - 1] = temp;
            heap.heapSize--;
            heap.heapify(0);
        }
    }
}
