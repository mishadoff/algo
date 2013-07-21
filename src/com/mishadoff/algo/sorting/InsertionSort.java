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
	public <T> void sort(List<T> elem, Comparator<T> comp) {
		for (int k = 1; k < elem.size(); k++) {
			T current = elem.get(k);
			int i = k - 1;
			while (i >= 0 && comp.compare(elem.get(i), current) > 0) {
				elem.set(i + 1, elem.get(i));
				i--;
			}
			elem.set(i + 1, current);
		}
	}
}
