package com.mishadoff.algo.search;

import java.util.Comparator;
import java.util.List;

/**
 * Common interface for all searching problems.
 * 
 * @author mishadoff
 *
 */
public interface Search {
	
	/* Search constants */
	public static final int NOT_FOUND = -1;
	
	/**
	 * Search for element in the specified array.<br>
	 * @param a input array
	 * @return index of first found element in the list, -1 otherwise.
	 */
	int search(int[] a, int e);
}
