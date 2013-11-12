package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Insertion sort.
 * 
 * @author mishadoff
 *
 */
public class InsertionSort implements Sort {
	
	@Override
	public <T> void sort(T[] a, Comparator<T> comp) {
		for (int k = 1; k < a.length; k++) {
			T current = a[k];
			int i = k - 1;
			while (i >= 0 && comp.compare(a[i], current) > 0) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = current;
		}
	}
}
