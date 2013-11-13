package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Insertion sort.
 * 
 * @author mishadoff
 *
 */
public class InsertionSort extends Sort {
	
	@Override
	public void sort(int[] a) {
		for (int k = 1; k < a.length; k++) {
			int current = a[k];
			int i = k - 1;
			while (i >= 0 && a[i] > current) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = current;
		}
	}
}
