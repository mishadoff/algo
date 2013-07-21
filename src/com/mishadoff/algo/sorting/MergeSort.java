package com.mishadoff.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements Sort {
	
	@Override
	public <T> void sort(List<T> elem, Comparator<T> comp) {
		mergeSort(elem, 0, elem.size() - 1, comp);
	}
	
	/**
	 * Recursive method for list sorting
	 * 
	 */
	private <T> void mergeSort(List<T> elem, int a, int b, Comparator<T> comp) {
		if (b - a > 0) { // list consists of more than one element so split it
			int midPoint = (a + b) / 2;
			mergeSort(elem, a, midPoint, comp); 	// sort two sublists recursively
			mergeSort(elem, midPoint + 1, b, comp);
			
			merge(elem, a, midPoint, b, comp);
		}
	}
	
	/**
	 * Merge two sorted lists into one sorted
	 * 
	 * @param a start of range 1
	 * @param midPoint end of range 1, start of range 2
	 * @param b end of range 2
	 */
	private <T> void merge(List<T> elem, int a, int midPoint, int b, Comparator<T> comp) {
		List<T> helpList = new ArrayList<>();	// TODO possible to move help list out of local variable
		
		// copy elements into help list
		for (int i = a; i <= b; i++) {
			helpList.add(elem.get(i));
		}
		
		// init pointers
		int i = a;
		int j = midPoint + 1;
		int k = a;
		
		while (i <= midPoint && j <= b) {
			if (comp.compare(helpList.get(i - a), helpList.get(j - a)) > 0) {
				elem.set(k, helpList.get(j - a));
				j++;
			} else {
				elem.set(k, helpList.get(i - a));
				i++;
			}
			k++;
		}
		
		while (i <= midPoint) {
			elem.set(k, helpList.get(i - a));
			k++; i++;
		}
	}
}
