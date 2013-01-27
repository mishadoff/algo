package com.mishadoff.algo.search;

import java.util.List;

/**
 * Common interface for all searching problems.
 * 
 * @author mishadoff
 *
 */
public interface Search {
	
	/**
	 * Search for element in the specified list.<br>
	 * Elements equality based on their `equals` method implementation. 
	 * 
	 * @param elems
	 * @returnindex of first found element in the list, -1 otherwise.
	 */
	<T> int search(List<T> elems, T elem);
}
