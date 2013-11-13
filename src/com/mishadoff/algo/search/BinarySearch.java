package com.mishadoff.algo.search;

public class BinarySearch implements Search {

	@Override
	public int search(int[] a, int e) {
		return binarySearch(a, e, 0, a.length - 1);
	}

	private int binarySearch(int[] a, int e, int start, int end) {
		if (end < start) {
			return NOT_FOUND;	// recursion stop condition
		} else {
			// split array in two parts
			int midPoint = (start + end) / 2;

			if (a[midPoint] > e) {					                    // mid element is greater
				return binarySearch(a, e, start, midPoint - 1);
			} else if (a[midPoint] < e) {			                    // mid element is smaller
				return binarySearch(a, e, midPoint + 1, end);
			} else {		                                            // element is found
				return midPoint;
			}	
		}
	}
}
