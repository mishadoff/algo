package com.mishadoff.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements Sort {

	@Override
	public <T> void sort(T[] a, Comparator<T> comp) {
		mergeSort(a, 0, a.length - 1, comp);
	}
	
	/**
	 * Recursive method for array sorting
	 * 
	 */
	private <T> void mergeSort(T[] a, int start, int end, Comparator<T> comp) {
		if (end - start > 0) { // array consists of more than one element so split it
			int midPoint = (start + end) / 2;
			mergeSort(a, start, midPoint, comp); 	// sort two subarrays recursively
			mergeSort(a, midPoint + 1, end, comp);
			
			merge(a, start, midPoint, end, comp);
		}
	}
	
	/**
	 * Merge two sorted arrays into one sorted
	 * 
	 * @param start start of range 1
	 * @param midPoint end of range 1, start of range 2
	 * @param end end of range 2
	 */
	private <T> void merge(T[] a, int start, int midPoint, int end, Comparator<T> comp) {
		List<T> helpList = new ArrayList<>();	// TODO possible to move help list out of local variable
		
		// copy elements into help list
		for (int i = start; i <= end; i++) {
			helpList.add(a[i]);
		}
		
		// init pointers
		int i = start;
		int j = midPoint + 1;
		int k = start;
		
		while (i <= midPoint && j <= end) {
			if (comp.compare(helpList.get(i - start), helpList.get(j - start)) > 0) {
				a[k] = helpList.get(j - start);
				j++;
			} else {
				a[k] = helpList.get(i - start);
				i++;
			}
			k++;
		}
		
		while (i <= midPoint) {
			a[k] = helpList.get(i - start);
			k++; i++;
		}
	}
}
