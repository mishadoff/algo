package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Class consists of different helper methods for sorting.
 * 
 * @author mishadoff
 *
 */
public final class SortUtils {
	
	private SortUtils() { }

	public static <T> boolean isSorted(List<T> elem, Comparator<T> comp) {
		boolean sorted = true;
		for (int i = 0; i < elem.size() - 1; i++) {
			T e1 = elem.get(i);
			T e2 = elem.get(i + 1);
			if (comp.compare(e1, e2) > 0) {
				sorted = false;
				break;
			}
		}
		return sorted;
	}

}
