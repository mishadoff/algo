package com.mishadoff.algo.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
	

	public static void main(String[] args) {
		Sort bubbleSort = new InsertionSort();
		List<Integer> elem = Arrays.asList(1, 4, 2, 9, 3, 8, 1, 2, 5, 6, 9, 2, 7);
		System.out.println("Unsorted: " + elem);
		bubbleSort.sort(elem, Comparators.INTEGER_COMPARATOR);
		System.out.println("Sorted: " + elem);
		bubbleSort.sort(elem, Comparators.INTEGER_COMPARATOR_REVERSE);
		System.out.println("Reverse sorted: " + elem);
	}

}
