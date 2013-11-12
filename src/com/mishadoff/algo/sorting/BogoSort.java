package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import com.mishadoff.algo.utils.SortUtils;

import java.util.Comparator;

/**
 * BogoSort is very ineffective sorting algorithm with O(Infinity) worst case.
 * 
 * WARNING: DONT USE IT IN PRACTICE, JUST FOR DEMONSTRATION PURPOSES
 * 
 * @author mishadoff
 *
 */
public class BogoSort implements Sort {

    @Override
	public <T> void sort(T[] a, Comparator<T> comp) {
		while (!SortUtils.isSorted(a, comp)) {
			ArrayUtils.shuffle(a);
		}
	}
}
