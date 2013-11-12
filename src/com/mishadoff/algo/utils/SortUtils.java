package com.mishadoff.algo.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Class consists of different helper methods for sorting.
 * 
 * @author mishadoff
 *
 */
public final class SortUtils {
	private SortUtils() { }

	public static <T> boolean isSorted(T[] a, Comparator<T> comp) {
		boolean sorted = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (comp.compare(a[i], a[i + 1]) > 0) {
				sorted = false;
				break;
			}
		}
		return sorted;
	}

}
