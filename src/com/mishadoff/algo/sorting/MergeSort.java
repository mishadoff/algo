package com.mishadoff.algo.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort extends Sort {
    private int[] helpArray;

	@Override
	public void sort(int[] a) {
        helpArray = new int[a.length]; // init help array
		mergeSort(a, 0, a.length - 1);
	}
	
	/**
	 * Recursive method for array sorting
	 * 
	 */
	private void mergeSort(int[] a, int start, int end) {
		if (end - start > 0) { // array consists of more than one element so split it
			int midPoint = (start + end) / 2;
			mergeSort(a, start, midPoint); 	// sort two subarrays recursively
			mergeSort(a, midPoint + 1, end);
			
			merge(a, start, midPoint, end);
		}
	}
	
	/**
	 * Merge two sorted arrays into one sorted
	 * 
	 * @param start start of range 1
	 * @param midPoint end of range 1, start of range 2
	 * @param end end of range 2
	 */
	private void merge(int[] a, int start, int midPoint, int end) {
		// copy elements into help list
		for (int i = start; i <= end; i++) {
			helpArray[i] = a[i];
		}
		
		// init pointers
		int i = start;
		int j = midPoint + 1;
		int k = start;
		
		while (i <= midPoint && j <= end) {
			if (helpArray[i] > helpArray[j]) {
				a[k] = helpArray[j];
				j++;
			} else {
				a[k] = helpArray[i];
				i++;
			}
			k++;
		}
		
		while (i <= midPoint) {
			a[k] = helpArray[i];
			k++; i++;
		}
	}
}
