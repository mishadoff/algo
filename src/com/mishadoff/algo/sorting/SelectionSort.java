package com.mishadoff.algo.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
	
	public static void main(String[] args) {
		Sort sort = new SelectionSort();
		List<Integer> elem = Arrays.asList(1, 4, 2, 9, 3, 8, 1, 2, 5, 6, 9, 2, 7);
		System.out.println("Unsorted: " + elem);
		sort.sort(elem, Comparators.INTEGER_COMPARATOR);
		System.out.println("Sorted: " + elem);
		sort.sort(elem, Comparators.INTEGER_COMPARATOR_REVERSE);
		System.out.println("Reverse sorted: " + elem);
	}
	
}
