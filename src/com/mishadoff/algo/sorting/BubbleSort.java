package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Bubble sort.
 * 
 * @author mishadoff
 *
 */
public class BubbleSort extends Sort {
	
	@Override
	public void sort(int[] a) {
		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
				}
			}
		}
	}
}
