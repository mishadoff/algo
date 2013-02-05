package com.mishadoff.algo.sorting;

import java.util.Arrays;
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
	
	public <T> void sort(List<T> elem, Comparator<T> comp) {
		while (!SortUtils.isSorted(elem, comp)) {
			Collections.shuffle(elem);
		}
	}

	public static void main(String[] args) {
		Sort sort = new BogoSort();
		List<Integer> elem = Arrays.asList(9, 1, 100, 4, 5, 7, 3, 2, 6, 8);
		System.out.println("Unsorted: " + elem);
		sort.sort(elem, Comparators.INTEGER_COMPARATOR);
		System.out.println("Sorted: " + elem);
		sort.sort(elem, Comparators.INTEGER_COMPARATOR_REVERSE);
		System.out.println("Reverse sorted: " + elem);
	}
}
