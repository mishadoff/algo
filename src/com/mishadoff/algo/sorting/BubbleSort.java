package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Bubble sort.
 * 
 * @author mishadoff
 *
 */
public class BubbleSort implements Sort {
	
	@Override
	public <T> void sort(T[] a, Comparator<T> comp) {
		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < a.length - 1; i++) {
				int cmp = comp.compare(a[i], a[i + 1]);
				if (cmp > 0) {
					T tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
				}
			}
		}
	}
}
