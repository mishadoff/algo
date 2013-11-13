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
	public abstract <T> void sort(T[] a, Comparator<T> comp);

    public <T extends Comparable<? super T>> void sort(T[] a) {
        sort(a, Comparators.natural());
    }
}
