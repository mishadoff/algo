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
	 * Search for element in the specified list.<br>
	 * Elements equality based on their `equals` method implementation. 
	 * 
	 * @param elems
	 * @returnindex of first found element in the list, -1 otherwise.
	 */
	<T> int search(List<T> elem, T e);
	
	/**
	 * Search for element in the specified list.<br>
	 * Comparator must be specified for comparison based search algorithms
	 * 
	 * @param elems
	 * @returnindex of first found element in the list, -1 otherwise.
	 */
	<T> int search(List<T> elem, T e, Comparator<T> comp);
}
