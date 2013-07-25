package com.mishadoff.algo.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	public <T> void sort(List<T> elem, Comparator<T> comp) {
		while (!SortUtils.isSorted(elem, comp)) {
			Collections.shuffle(elem);
		}
	}
}
