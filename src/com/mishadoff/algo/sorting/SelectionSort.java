package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Selection sort.
 * 
 * @author mishadoff
 *
 */
public class SelectionSort extends Sort {
	
	@Override
	public void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) { // search for the min
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (i != min) { // swap
				swap(a, i, min);
			}
		}
	}
}
