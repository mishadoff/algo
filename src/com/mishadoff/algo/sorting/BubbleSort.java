package com.mishadoff.algo.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Bubble sort.
 * 
 * @author mishadoff
 *
 */
public class BubbleSort implements Sort{
	
	@Override
	public <T> void sort(List<T> elem, Comparator<T> comp) {
		for (int k = 0; k < elem.size(); k++) {
			for (int i = 0; i < elem.size() - 1; i++) {
				int cmp = comp.compare(elem.get(i), elem.get(i + 1));
				if (cmp > 0) {
					T tmp = elem.get(i);
					elem.set(i, elem.get(i + 1));
					elem.set(i + 1, tmp);
				}
			}
		}
	}
}
