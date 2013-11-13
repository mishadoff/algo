package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Common interface for all sorting algorithms.
 * Sort in place.
 * 
 * @author mishadoff
 *
 */
public abstract class Sort {
	public abstract void sort(int[] a);

    protected void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
