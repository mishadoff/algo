package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Selection sort.
 * 
 * @author mishadoff
 *
 */
public class SelectionSort implements Sort {
	
	@Override
	public <T> void sort(T[] a, Comparator<T> comp) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) { // search for the min
				if (comp.compare(a[j], a[min]) < 0) {
					min = j;
				}
			}
			if (i != min) { // swap
				T e = a[i];
				a[i] = a[min];
				a[min] = e;
			}
		}
	}
}
