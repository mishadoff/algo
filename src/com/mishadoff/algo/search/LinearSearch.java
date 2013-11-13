package com.mishadoff.algo.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LinearSearch implements Search {

	@Override
	public int search(int[] a, int e) {
		int idx = NOT_FOUND;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == (e)) {
				idx = i;
				break;
			} 
		}
		return idx;
	}
}
