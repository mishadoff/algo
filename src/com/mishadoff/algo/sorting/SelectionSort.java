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
	public <T> void sort(List<T> elem, Comparator<T> comp) {
		for (int i = 0; i < elem.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < elem.size(); j++) {
				if (comp.compare(elem.get(j), elem.get(min)) < 0) {
					min = j;
				}
			}
			if (i != min) { // swap
				T e = elem.get(i);
				elem.set(i, elem.get(min));
				elem.set(min, e);
			}
		}
	}
}
